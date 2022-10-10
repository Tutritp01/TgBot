package com.tutrit.stoservice.controller;


public enum Command {

    SHOW_DATA("show data"),
    SAVE_CAR("save car"),
    EXIT("exit"),
    HELP("help"),
    NOT_A_COMMAND(null);
    final String command;

    Command(String command) {
        this.command = command;
    }


    public static Command fromString(String command) {
        return switch (command) {
            case "show data" -> SHOW_DATA;
            case "exit" -> EXIT;
            case "help" -> HELP;
            case "save car" -> SAVE_CAR;
            default -> NOT_A_COMMAND;
        };
    }
}
