package com.tutrit.stoservice.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InputCommandTest {
    InputCommand inputCommand = new InputCommand();

    @Test
    void inputMsg() {
        Map<String, String> map =new HashMap<>();
        map = inputCommand.inputMsg("Show data -m");
        assertEquals("Show data", map.get("command"));
    }
}