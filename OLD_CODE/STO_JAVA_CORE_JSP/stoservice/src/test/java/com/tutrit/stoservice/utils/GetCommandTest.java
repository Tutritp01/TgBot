package com.tutrit.stoservice.utils;

import org.junit.jupiter.api.Test;

import static com.tutrit.stoservice.utils.GetCommand.*;
import static org.junit.jupiter.api.Assertions.*;

class GetCommandTest {

    @Test
    void getCommandTest() {
        assertEquals("show data", getCommand("show data -m"));
    }

    @Test
    void getCommandOneWorld() {
        assertEquals("help", getCommand("help"));
    }

    @Test
    void getCommandTwoWorlds() {
        assertEquals("show data", getCommand("show data"));
    }

    @Test
    void GetCommandNull() {
        assertEquals("", getCommand(""));
    }
}
