package com.tutrit.tgbot.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class LogConsole {
    private static final Logger log = LoggerFactory.getLogger("LogConsole");

    public void logConsol(Update update){
        log.info("User:{}, ChatId:{}, Text:{}", update.getMessage().getChat().getUserName(), update.getMessage().getChatId(), update.getMessage().getText());
    }
}
