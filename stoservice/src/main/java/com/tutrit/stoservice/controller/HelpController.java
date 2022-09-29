package com.tutrit.stoservice.controller;

import java.util.Arrays;

public class HelpController implements CommandController {
    private static final Command command = Command.HELP;

    public void doCommand(Request request, Response response) {
        response.setResponse(String.format(Arrays.toString(Command.values()), request.getCommand()));
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
