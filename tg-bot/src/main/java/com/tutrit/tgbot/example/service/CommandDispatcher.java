package com.tutrit.tgbot.example.service;

import com.tutrit.tgbot.example.bean.Command;
import com.tutrit.tgbot.example.exception.CommandNotFoundException;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class CommandDispatcher {
    private String dispatchCommand(final Update update, final String msgText) throws CommandNotFoundException {
        return Command.getProcessorByName(msgText).process(update);
    }

    public SendMessage processUpdate(final Update update) {
        try {
            return createResponse(update);
        }catch (CommandNotFoundException e) {
            System.out.println(e.getMessage());
            return defaultResponse(update);
        }
    }

    private SendMessage createResponse(final Update update) throws CommandNotFoundException {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(this.dispatchCommand(update, update.getMessage().getText()));
        return sendMessage;
    }

    private SendMessage defaultResponse(final Update update) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("Do no");
        return sendMessage;
    }
}
