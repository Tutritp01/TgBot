package com.tutrit.stoservice.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InputCommandTest {
    InputCommand inputCommand = new InputCommand();

    @Test
    void inputMsg() {
        Map<String, String> map = new HashMap<>();
        map = inputCommand.inputMsg("Show data -m -d {id:12 name:Viktor}");
        assertEquals("Show data", map.get("command"));
        assertEquals("m", map.get("format"));
        assertEquals("id:12 name:Viktor", map.get("object"));
    }
}
