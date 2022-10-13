package com.tutrit.stoservice.controller;

import java.util.*;

public enum Command {

    SHOW_DATA("show data"),
    EXIT("exit"),
    HELP("help"),
    NEW_ENGINEER("new engineer"),
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
            case "new engineer" -> NEW_ENGINEER;
            default -> NOT_A_COMMAND;
        };
    }
}
