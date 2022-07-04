package com.tutrit.tgbot.example.util;

import com.tutrit.tgbot.example.bean.UserDataTg;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class CreateUserTg {
    public UserDataTg createUserTg(Update update) {
        UserDataTg userDataTg = new UserDataTg();
        userDataTg.setName(update.getMessage().getFrom().getUserName());
        userDataTg.setUserId(update.getMessage().getFrom().getId());
        userDataTg.setChatId(update.getMessage().getChatId());
        return userDataTg;
    }
}
