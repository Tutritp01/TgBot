package com.tutrit.stoservice.controller;

public enum Command {
    NOT_A_COMMAND(null),
    SHOW_DATA ("show data"),
    EXIT("exit");

    String command;

    Command(final String command) {
        this.command = command;
    }

    public static Command ofCommand(String command) {
        return switch (command) {
            case "show data" -> SHOW_DATA;
            case "exit" -> EXIT;
            default -> NOT_A_COMMAND;
        };
    }
}
