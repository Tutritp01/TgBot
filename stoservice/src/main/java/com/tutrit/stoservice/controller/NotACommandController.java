package com.tutrit.stoservice.controller;

public class NotACommandController {

    public void doCommand(Request request, Response response) {
        response.setResponse(String.format("\"%s\" not a valid command", request.getCommand()));
    }
}
