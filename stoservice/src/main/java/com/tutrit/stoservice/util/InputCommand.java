package com.tutrit.stoservice.util;

import java.util.HashMap;
import java.util.Map;

public class InputCommand {


    static Map<String, String> inputMsg(String inputMsg) {
        Map<String, String> map = new HashMap<>();
        map.put("command", inputMsg.substring(0, inputMsg.indexOf('-')).trim());
        map.put("format", inputMsg.substring(inputMsg.indexOf('-') + 1, inputMsg.indexOf('-') + 2));
        String object = inputMsg.substring(inputMsg.indexOf("-d"));
        object = object.substring(object.indexOf('{') + 1, object.indexOf('}'));
        map.put("object", object);
        return map;
    }
}
