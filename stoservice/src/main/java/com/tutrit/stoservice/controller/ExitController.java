package com.tutrit.stoservice.controller;

public class ExitController implements CommandController {
    public void doCommand(Request request, Response response) {
        System.exit(0);
    }
}
