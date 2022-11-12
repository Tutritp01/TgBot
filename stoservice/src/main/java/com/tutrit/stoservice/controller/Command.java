package com.tutrit.stoservice.controller;

public enum Command {

    SHOW_DATA("show data"),
    SAVE_CAR("save car"),
    GET_CAR("get car"),
    EXIT("exit"),
    HELP("help"),
    NEW_CUSTOMER("new customer"),
    NEW_ENGINEER("new engineer"),
    GET_ENGINEER("get engineer"),
    REGISTER_NEW_USER("new_user"),
    REGISTER("register"),
    NEW_ORDER("new order"),
    GET_ORDER("get order"),
    NEW_EVENT("new event"),
    NOT_A_COMMAND(null);
    final String commands;

    Command(String commands) {
        this.commands = commands;
    }

    public static Command fromString(String command) {
        return switch (command) {
            case "show data" -> SHOW_DATA;
            case "exit" -> EXIT;
            case "help" -> HELP;
            case "new customer" -> NEW_CUSTOMER;
            case "new_user" -> REGISTER_NEW_USER;
            case "new engineer" -> NEW_ENGINEER;
            case "get engineer" -> GET_ENGINEER;
            case "save car" -> SAVE_CAR;
            case "get car" -> GET_CAR;
            case "register" -> REGISTER;
            case "new order" -> NEW_ORDER;
            case "get order" -> GET_ORDER;
            case "new event" -> NEW_EVENT;
            default -> NOT_A_COMMAND;
        };
    }
}
