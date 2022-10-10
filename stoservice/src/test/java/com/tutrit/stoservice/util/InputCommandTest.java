package com.tutrit.stoservice.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InputCommandTest {


    @Test
    void inputMsg() {
        Map<String, String> map = InputCommand.inputMsg("Show data -m -d {id:12 name:Viktor}");
        assertEquals("Show data", map.get("command"));
        assertEquals("m", map.get("format"));
        assertEquals("id:12 name:Viktor", map.get("object"));
    }

    @Test
    void inputCommandOnly(){
        Map<String, String> map = InputCommand.inputMsg("help");
        assertEquals("help", map.get("command"));
    }

    @Test
    void NewEngineer() {
        Map<String, String> map = InputCommand.inputMsg("new engineer -m -d {LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}");
        assertEquals("LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7", map.get("object"));
    }
}
