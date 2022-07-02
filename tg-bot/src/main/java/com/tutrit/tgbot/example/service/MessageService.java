package com.tutrit.tgbot.example.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {
    public SendMessage onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        if(update != null) {
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            if (message != null && message.hasText()) {
                String msgText = message.getText();
                if (msgText.equals("/start")) {
                    sendMessage.setText("Hello");
                    return sendMessage;
                } else if (msgText.equals("/help")) {
                    sendMessage.setText("Help");
                    return sendMessage;
                } else if (msgText.equals("/settings")){
                    sendMessage.setText("Settings");
                    return sendMessage;
                }
            }
        }
        sendMessage.setText("Do no");
        return sendMessage;
    }
}
