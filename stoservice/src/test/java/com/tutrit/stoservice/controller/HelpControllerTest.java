package com.tutrit.stoservice.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelpControllerTest {
    HelpController helpController = new HelpController();
    Response response = new Response();

    @Test
    void doCommand() {
        helpController.doCommand(new Request(""), response);
        assertEquals(Arrays.stream(Command.values())
                .map(e -> e.command)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", ")), response.getResponse());
    }

    @Test
    void getCommand() {
        assertEquals("HELP", helpController.getCommand().toString());
    }
}
