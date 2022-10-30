package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Engineer;

import java.util.HashMap;

public class UserInputToEngineer {

    private UserInputToEngineer() {
        throw new IllegalStateException("Utility class");
    }

    public static Engineer getEngineer(String inputMsg) {
        HashMap<String, String> map;
        String[] keyAndSplit = getKey(inputMsg).split(":", 2);
        var object = getObject(inputMsg);
        if (object == null) {
            return makeEngineer(new HashMap<>());
        }
        map = switch (keyAndSplit[0]) {
            case "json" -> objectToMapJson(object);
            case "m" ->
                    keyAndSplit.length > 1 ? objectToMap(object, keyAndSplit[1].substring(0, 1)) : objectToMap(object, " ");
            default -> new HashMap<>();
        };

        return makeEngineer(map);
    }

    private static String getObject(String inputMsg) {
        if (inputMsg.contains("{") && inputMsg.contains("}")) {
            return inputMsg.substring(inputMsg.indexOf('{') + 1, inputMsg.indexOf('}'));
        }
        return null;
    }

    private static String getKey(String inputMsg) {
        if (inputMsg.contains("-") && inputMsg.contains("-d")) {
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
            engineer.setFirstName(map.get("FirstName"));
            engineer.setLastName(map.get("LastName"));
            engineer.setFunction(map.get("Function"));
            engineer.setCategory(map.get("Category"));
            engineer.setEducation(map.get("Education"));
            engineer.setExperience(Integer.parseInt(map.get("Experience")));
            engineer.setGeneralExperience(Integer.parseInt(map.get("GeneralExperience")));
            return engineer;
        }
        return null;
    }
}
