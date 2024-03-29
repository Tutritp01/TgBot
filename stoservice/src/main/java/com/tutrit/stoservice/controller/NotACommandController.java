package com.tutrit.stoservice.controller;

public class NotACommandController implements CommandController {
    private static final Command command = Command.NOT_A_COMMAND;

    public void doCommand(Request request, Response response) {
        response.setResponse("print 'help' to see list of available commands");
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
