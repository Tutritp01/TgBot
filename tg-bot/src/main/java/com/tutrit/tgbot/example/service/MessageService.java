package com.tutrit.tgbot.example.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.tutrit.tgbot.example.constants.ChatBotCommands.GET_ORDER_STATUS;
import static com.tutrit.tgbot.example.constants.ChatBotCommands.START;

@Service
public class MessageService {

	public SendMessage onUpdateReceived(Update update) {
		SendMessage sendMessage = new SendMessage();
		if (update != null) {
			Message message = update.getMessage();
			sendMessage.setChatId(message.getChatId());
			if (message != null && message.hasText()) {
				String magText = message.getText();
				if (magText.equals(START.getCommand())) {
					sendMessage.setText("Hello!");
					return sendMessage;
				} else if (magText.equals(GET_ORDER_STATUS.getCommand())) {
					sendMessage.setText("Get order status!");
					return sendMessage;
				} else if (magText.equals("/settings")) {
					sendMessage.setText("Settings!");
					return sendMessage;
				} else if (magText.equals("/help")) {
					sendMessage.setText("Help!");
					return sendMessage;
				}
			}
		}
		sendMessage.setText("Do no");
		return sendMessage;
	}
}
