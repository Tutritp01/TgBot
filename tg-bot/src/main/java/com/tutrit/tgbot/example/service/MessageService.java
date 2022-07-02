package com.tutrit.tgbot.example.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {
    public String onUpdateReceived(Update update) {
        if(update != null) {
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                String msgText = message.getText();
                if (msgText.equals("/start")) {
                    return "Hello";
                } else if (msgText.equals("/help")) {
                    return "Help";
                } else if (msgText.equals("/settings")){
                    return "Settings";
                }
            }
        }
        return "Do no";

    }
}
