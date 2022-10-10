package com.tutrit.stoservice.util;

import java.util.HashMap;
import java.util.Map;

public class InputCommand {

    public static Map<String, String> inputMsg(String inputMsg) {
        Map<String, String> map = new HashMap<>();
        if (inputMsg.indexOf('-') > 0) {
            map.put("command", inputMsg.substring(0, inputMsg.indexOf('-')).trim());
            map.put("format", inputMsg.substring(inputMsg.indexOf('-') + 1, inputMsg.indexOf('-') + 2));
            String object = inputMsg.substring(inputMsg.indexOf("-d"));
            object = object.substring(object.indexOf('{') + 1, object.indexOf('}'));
            map.put("object", object);
        } else {
            map.put("command", inputMsg.trim());
        }
        return map;
    }
}
