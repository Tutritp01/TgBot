package com.tutrit.stoservice.controller;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class HelpController implements CommandController {
    private static final Command command = Command.HELP;

    public void doCommand(Request request, Response response) {
        response.setResponse(Arrays.stream(Command.values())
                .map(e -> e.commands)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", ")));
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
