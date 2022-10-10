package com.tutrit.stoservice.controller;

import java.util.Arrays;
import java.util.Map;

public class HelpController implements CommandController {
    private static final Command command = Command.HELP;

    public void doCommand(Map request, Response response) {
        response.setResponse(String.format(Arrays.toString(Command.values()), request.get("command")));
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
