package com.tutrit.stoservice.util;

import java.util.HashMap;
import java.util.Map;

public class InputCommand {


    static Map<String, String> inputMsg(String inputMsg) {
        Map<String, String> map = new HashMap<>();
        int indexCommand = inputMsg.indexOf('-');
        String command1 = inputMsg.substring(0, indexCommand).trim();
        map.put("command", command1);
        return map;

    }
}
