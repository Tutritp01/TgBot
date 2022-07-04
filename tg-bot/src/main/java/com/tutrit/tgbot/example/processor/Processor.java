package com.tutrit.tgbot.example.processor;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Processor {
    String process(Update update);
}
