package com.tutrit.stoservice.controller;

import java.util.List;

import static com.tutrit.stoservice.utils.UtilsInput.parseFlags;

public class Request {
    private String command;
    private final String information;

    public Request(String userInput) {
        List<String> parsUserInput = parseFlags(userInput);
        this.command = parsUserInput.get(0);
        information = parsUserInput.get(1);
    }

    public String getInformation() {
        return information;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
