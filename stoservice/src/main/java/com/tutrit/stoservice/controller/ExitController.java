package com.tutrit.stoservice.controller;

public class ExitController implements CommandController {
    private static final Command command = Command.EXIT;

    public void doCommand(Request request, Response response) {
        System.exit(0);
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
