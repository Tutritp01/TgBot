package com.tutrit.tgbot.example;

import com.tutrit.tgbot.example.config.Mapper;
import com.tutrit.tgbot.example.service.MessageService;
import com.tutrit.tgbot.example.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
public class TelegrambotApplicationTests {

    @Test
    void contextLoads() {
    }
}