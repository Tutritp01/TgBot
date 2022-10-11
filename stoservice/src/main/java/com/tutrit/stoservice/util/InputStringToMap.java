package com.tutrit.stoservice.util;

import com.tutrit.stoservice.bean.Engineer;

import java.util.HashMap;
import java.util.Map;

public class InputStringToMap {

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

    public static Engineer stringToEngineer(String objects) {
        String object = objects.get("object").toString();
        Map<String, String> map = new HashMap<>();

        String[] flagAndArgs = object.split(" ");
        for (String block : flagAndArgs) {
            String[] temp = block.split(":");
            map.put(temp[0], temp[1]);
        }
        Engineer engineer = new Engineer(
                "temp",
                map.get("LN"),
                map.get("FN"),
                map.get("Fun"),
                map.get("Cat"),
                map.get("Edu"),
                Integer.parseInt(map.get("Exp")),
                Integer.parseInt(map.get("GExp"))
        );
        return engineer;
    }
}
