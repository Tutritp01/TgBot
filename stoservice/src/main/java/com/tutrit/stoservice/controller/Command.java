package com.tutrit.stoservice.controller;

public enum Command {

    SHOW_DATA("show data"),
    EXIT("exit"),
    HELP("help"),

    NEW_CUSTOMER("new customer"),
    NOT_A_COMMAND(null);
    String command;

    Command(String command) {
        this.command = command;
    }


    public static Command fromString(String command) {
        return switch (command) {
            case "show data" -> SHOW_DATA;
            case "exit" -> EXIT;
            case "help" -> HELP;
            case "new customer" -> NEW_CUSTOMER;
            default -> NOT_A_COMMAND;
        };
    }
}
