package com.tutrit.stoservice.controller;

import java.util.*;

public enum Command {

    SHOW_DATA("showData"),
    SAVE_CAR("saveCar"),
    EXIT("exit"),
    HELP("help"),
    NOT_A_COMMAND(null);
    String command;

    Command(String command) {
        this.command = command;
    }


    public static Command fromString(String command) {
        return switch (command) {
            case "showData" -> SHOW_DATA;
            case "exit" -> EXIT;
            case "help" -> HELP;
            case "saveCar" -> SAVE_CAR;
            default -> NOT_A_COMMAND;
        };
    }
}
