package com.tutrit.stoservice.controller;

import java.util.Arrays;

public class HelpController {

    public void doCommand(Request request, Response response) {
        response.setResponse(String.format(Arrays.toString(Command.values()), request.getCommand()));
    }
}
