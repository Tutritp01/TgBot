package com.tutrit.stoservice.controller;

import java.security.PrivateKey;
import java.util.Arrays;

public class HelpController implements CommandController {
    private static final Command command = Command.HELP;
    private final String ANY = "Any wrong input will return to the beginning";

    public void doCommand(Request request, Response response) {
        response.setResponse(Arrays.toString(Arrays.stream(Command.values())
                .map(e -> e.command != null ? e.command : ANY)
                .toArray()));
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
