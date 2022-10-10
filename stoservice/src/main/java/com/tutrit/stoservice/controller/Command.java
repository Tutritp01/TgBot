package com.tutrit.stoservice.controller;

import java.util.*;

public enum Command {

    SHOW_DATA("show data"),
    EXIT("exit"),
    HELP("help"),
    NOT_A_COMMAND(null),
    REGISTER_NEW_ORDER("new order");
    String command;

    Command(String command) {
        this.command = command;
    }


    public static Command fromString(String command) {
        return switch (command) {
            case "show data" -> SHOW_DATA;
            case "exit" -> EXIT;
            case "help" -> HELP;
            case "new order" -> REGISTER_NEW_ORDER;
            default -> NOT_A_COMMAND;
        };
    }
}
