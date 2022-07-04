package com.tutrit.tgbot.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutrit.tgbot.example.bean.UserDataTg;
import com.tutrit.tgbot.example.config.Mapper;
import com.tutrit.tgbot.example.service.LogConsole;
import com.tutrit.tgbot.example.service.MessageService;
import com.tutrit.tgbot.example.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class, LogConsole.class, CreateUserTg.class, UserDataTg.class})
class CreateUserTgTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;

    @Test
    void createUserTg() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/start.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = forTestMessage("Hello");
        assertEquals(expectedResult, actualResult);
        String nameIn = update.getMessage().getFrom().getUserName();
        String nameOut = messageService.userDataTg.getName();
        assertEquals(nameIn, nameOut);
        long UserIdIn = update.getMessage().getFrom().getId();
        long UserIdOut = messageService.userDataTg.getUserId();
        assertEquals(UserIdIn, UserIdOut);
        long ChatIdIn = update.getMessage().getChatId();
        long ChatIdOut = messageService.userDataTg.getChatId();
        assertEquals(ChatIdIn, ChatIdOut);
    }

    private SendMessage forTestMessage(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(217897540L);
        sendMessage.setText(text);
        return sendMessage;
    }
}