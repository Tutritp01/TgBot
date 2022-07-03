package com.tutrit.tgbot.example.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;


@Service
public class MessageService {

    public SendMessage onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update != null) {
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            if (message.hasText()) {
                String magText = message.getText();
                if (magText.equals("/start")) {
                    sendMessage.setText("Привет, это СТО 'винтик и шпунтик' что бы ты хотел сделать? " +
                            "\n Получить помошь - /help " +
                            "\n Узнать что с машиной - /status " +
                            "\n Ввести дополнительные данные - /settings");
                    return sendMessage;
                } else if (magText.equals("/settings")) {
                    sendMessage.setText("Settings");
                    return sendMessage;
                } else if (magText.equals("/help")) {
                    sendMessage.setText("Help");
                    return sendMessage;
                } else if (magText.equals("/status")) {
                    sendMessage.setText("Status");
                    return sendMessage;
                }
            }
            sendMessage.setText("Попробуй еще раз!");
            return sendMessage;
        }
        return sendMessage;
    }
}
