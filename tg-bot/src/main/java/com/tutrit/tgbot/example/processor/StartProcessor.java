package com.tutrit.tgbot.example.processor;

import com.tutrit.tgbot.example.util.CreateUserTg;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class StartProcessor implements Processor {
    CreateUserTg createUserTg = new CreateUserTg();

    @Override
    public String process(Update update) {
        createUserTg.createUserTg(update);
        return "Hello";
    }
}
