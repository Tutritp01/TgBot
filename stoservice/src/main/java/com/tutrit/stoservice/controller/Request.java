package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.parser.UserInput;

public class Request {
    private String command;
    private UserInput userInput;

    public Request(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(final UserInput userInput) {
        this.userInput = userInput;
    }
}

