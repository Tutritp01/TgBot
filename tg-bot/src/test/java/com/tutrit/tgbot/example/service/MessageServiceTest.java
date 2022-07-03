package com.tutrit.tgbot.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutrit.tgbot.example.TelegrambotApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MessageServiceTest extends TelegrambotApplicationTests {

    @Autowired
    TelegramBot telegramBot;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;

    @Test
    void onUnknownReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMassage("Попробуй еще раз!");
        assertEquals(expectedResult,actualResult);

    }
    @Test
    void onStartReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/start.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMassage("Привет, это СТО 'винтик и шпунтик' что бы ты хотел сделать? \n" +
                " Получить помошь - /help \n" +
                " Узнать что с машиной - /status \n" +
                " Ввести дополнительные данные - /settings");
        assertEquals(expectedResult,actualResult);

    }
    @Test
    void onSettingsReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/settings.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMassage("Settings");
        assertEquals(expectedResult,actualResult);

    }
    @Test
    void onHelpReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/help.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMassage("Help");
        assertEquals(expectedResult,actualResult);

    }
    @Test
    void onStatusReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/status.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMassage("Status");
        assertEquals(expectedResult, actualResult);
    }
    private SendMessage makeMassage(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(1035881400L));
        sendMessage.setText(text);
        return sendMessage;
    }
}