package com.tutrit.stoservice.controller;

public enum Command {

    SHOW_DATA("show data"),
    SAVE_CAR("save car"),
    EXIT("exit"),
    HELP("help"),
    NEW_CUSTOMER("new customer"),
    NEW_ENGINEER("new engineer"),
    REGISTER_NEW_USER("new_user"),

    GET_CUSTOMER(" get customer"),
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
            case "new_user" -> REGISTER_NEW_USER;
            case "new engineer" -> NEW_ENGINEER;
            case "save car" -> SAVE_CAR;
            case "get customer" -> GET_CUSTOMER;
            default -> NOT_A_COMMAND;
        };
    }
}
