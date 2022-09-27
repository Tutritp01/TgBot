package com.tutrit.stoservice.controller;

public class NotACommandController implements CommandController {

    public void doCommand(Request request, Response response) {
        response.setResponse("print 'help' to see list of available commands");
    }
}
