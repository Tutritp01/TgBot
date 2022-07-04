package com.tutrit.tgbot.example.processor;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class SettingsProcessor implements Processor {

    @Override
    public String process(Update update) {
        return "Settings";
    }
}
