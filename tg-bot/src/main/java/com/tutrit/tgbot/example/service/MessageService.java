package com.tutrit.tgbot.example.service;

import com.tutrit.tgbot.example.bean.UserDataTg;
import com.tutrit.tgbot.example.util.CreateUserTg;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {
    CreateUserTg createUserTg = new CreateUserTg();
    public UserDataTg userDataTg = new UserDataTg();

    public SendMessage onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update != null) {
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            if (message.hasText()) {
                String msgText = message.getText();
                if (msgText.equals("/start")) {
                    userDataTg = createUserTg.createUserTg(update);
                    sendMessage.setText("Hello");
                    return sendMessage;
                } else if (msgText.equals("/help")) {
                    sendMessage.setText("Help");
                    return sendMessage;
                } else if (msgText.equals("/settings")) {
                    sendMessage.setText("Settings");
                    return sendMessage;
                }
            }
        }
        sendMessage.setText("Do no");
        return sendMessage;
    }
}
