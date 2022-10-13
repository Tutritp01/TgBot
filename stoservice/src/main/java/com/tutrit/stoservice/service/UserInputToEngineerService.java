package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;

import java.util.HashMap;

public class UserInputToEngineerService {

    public static Engineer getEngineer(String inputMsg) {
        HashMap<String, String> map;
        String[] keyAndSplit = getKey(inputMsg).split(":", 2);
        var object = getObject(inputMsg);
        if (object == null) {
            return makeEngineer(new HashMap<>());
        }
        switch (keyAndSplit[0]) {
            case "json":
                map = objectToMapJson(object);
                break;
            case "m":
                map = keyAndSplit.length > 1 ? objectToMap(object, keyAndSplit[1].substring(0, 1)) : objectToMap(object, " ");
                break;
            default:
                map = new HashMap<>();
        }

        return makeEngineer(map);
    }

    private static String getObject(String inputMsg) {
        if (inputMsg.indexOf('{') > 0 && inputMsg.indexOf("}") > 0) {
            return inputMsg.substring(inputMsg.indexOf('{') + 1, inputMsg.indexOf('}'));
        }
        return null;
    }

    private static String getKey(String inputMsg) {
        if (inputMsg.indexOf('-') > 0 && inputMsg.indexOf("-d") > 0) {
            return inputMsg.substring(inputMsg.indexOf('-') + 1, inputMsg.indexOf("-d")).trim();
        }
        return "null";
    }

    private static HashMap<String, String> objectToMap(String object, String split) {
        HashMap<String, String> map = new HashMap<>();
        switch (split) {
            case "|":
                split = "\\|";
        }
        if (!object.equals("")) {
            String[] flagAndArgs = object.split(split);
            for (String block : flagAndArgs) {
                String[] temp = block.split(":");
                map.put(temp[0], temp[1]);
            }
        }
        return map;
    }

    private static HashMap<String, String> objectToMapJson(String object) {
        HashMap<String, String> map = new HashMap<>();
        if (!object.equals("")) {
            String[] flagAndArgs = object.split(",");
            for (String block : flagAndArgs) {
                String[] temp = block.trim().split(":");
                temp[0] = temp[0].replace("\"", "");
                temp[1] = temp[1].replace("\"", "");
                map.put(temp[0], temp[1]);
            }
        }
        return map;
    }

    private static Engineer makeEngineer(HashMap<String, String> map) {
        var engineer = new Engineer();
        if (!map.isEmpty()) {
            engineer.setIdEngineer("temp");
            engineer.setFirstName(map.get("FN"));
            engineer.setLastName(map.get("LN"));
            engineer.setFunction(map.get("Fun"));
            engineer.setCategory(map.get("Cat"));
            engineer.setEducation(map.get("Edu"));
            engineer.setExperience(Integer.parseInt(map.get("Exp")));
            engineer.setGeneralExperience(Integer.parseInt(map.get("GExp")));
            return engineer;
        }
        return null;
    }
}
