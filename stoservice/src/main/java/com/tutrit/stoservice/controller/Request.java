package com.tutrit.stoservice.controller;

public class Request {
    private String command;

    public Request(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}

