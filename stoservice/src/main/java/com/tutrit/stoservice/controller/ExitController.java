package com.tutrit.stoservice.controller;

import java.util.Map;

public class ExitController implements CommandController {
    private static final Command command = Command.EXIT;

    public void doCommand(Map request, Response response) {
        System.exit(0);
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
