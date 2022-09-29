package com.tutrit.stoservice.controller;

public interface CommandController {
    Command getCommand();
    void doCommand(Request request, Response response);
}
