package com.tutrit.tgbot.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;

@Component
@PropertySource("application.properties")
public class TelegramBot extends TelegramLongPollingBot  {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = messageService.onUpdateReceived(update);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void savejson (Update update)
        {
            try {
                objectMapper.writeValue(new File("tg-bot/src/test/resources/update.json"), update);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public String getBotUsername () {
            return botUsername;
        }

        @Override
        public String getBotToken () {
            return botToken;
        }
    }
/*
      try {
           sendMessage = createResponse(update);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

   private SendMessage createResponse(final Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update.getMessage().getText().equals("/start")){
            sendMessage.setText("Привет,ты все делаешь правильно");
            sendMessage.setChatId(update.getMessage().getChatId().toString());
            return sendMessage;

        } else {
            sendMessage.setText("Welcome! Got your message: " + update.getMessage().getText());
            sendMessage.setChatId(update.getMessage().getChatId().toString());
            return sendMessage;
        }
    }*/


