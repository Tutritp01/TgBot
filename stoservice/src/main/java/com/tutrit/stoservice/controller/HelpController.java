package com.tutrit.stoservice.controller;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class HelpController implements CommandController {
    private static final Command command = Command.HELP;

    public void doCommand(Request request, Response response) {
        String output = Arrays.stream(Command.values())
                .map(e -> e.command)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
        response.setResponse(output);
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
