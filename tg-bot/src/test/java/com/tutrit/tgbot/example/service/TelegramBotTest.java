package com.tutrit.tgbot.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutrit.tgbot.example.TelegrambotApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;

class TelegramBotTest extends TelegrambotApplicationTests{
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    ObjectMapper objectMapper;

//   @Test
    void onUpdateReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
   telegramBot.onUpdateReceived(update);
    }
//    @Test
    void sendMassage() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(1035881400L);
        sendMessage.setText("Hello bot");
        telegramBot.execute(sendMessage);
    }
}