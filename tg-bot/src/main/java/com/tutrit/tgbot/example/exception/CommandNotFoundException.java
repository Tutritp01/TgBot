package com.tutrit.tgbot.example.exception;

public class CommandNotFoundException extends Exception{
    public CommandNotFoundException(final String message) {
        super(message);
    }
}
