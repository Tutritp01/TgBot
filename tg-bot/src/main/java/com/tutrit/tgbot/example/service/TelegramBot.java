package com.tutrit.tgbot.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.*;
@Service
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;
    @Autowired
    LogConsole logConsole;
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = messageService.onUpdateReceived(update);
        try {
            logConsole.logConsol(update);
            execute(sendMessage);
            execute(createResponse(update));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        //try {
        //    var sendMessage = createResponse(update);
        //    execute(sendMessage);
        //} catch (TelegramApiException e) {
        //    e.printStackTrace();
        //}
    }

    private void saveJson(Update update) {
        try {
            objectMapper.writeValue(new File("src/test/resources/update.json"), update);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SendMessage createResponse(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("got your message: " + update.getMessage().getText());
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        return sendMessage;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
