package com.tutrit.tgbot.example.service;

import com.tutrit.tgbot.example.OrderStatus.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class StatusServiceTest {

    @Autowired
    TelegramBot telegramBot;
    @Autowired
    MessageService messageService;

    @Test
   void choice() {
        StatusService.choice(OrderStatus.REQUEST);


    }

}