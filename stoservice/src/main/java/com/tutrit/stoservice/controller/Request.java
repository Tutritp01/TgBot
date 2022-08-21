package com.tutrit.stoservice.controller;

public class Request {
    private String command;

    public Request(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(final String command) {
        this.command = command;
    }
}
