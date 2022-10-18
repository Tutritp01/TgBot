package com.tutrit.stoservice.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpControllerTest {
    HelpController helpController = new HelpController();
    Response response = new Response();

    @Test
    void doCommand() {
        helpController.doCommand(new Request(""), response);
        assertEquals("show data, exit, help, Any wrong input will return to the beginning", response.getResponse());
    }

    @Test
    void getCommand() {
        assertEquals("HELP", helpController.getCommand().toString());
    }
}
