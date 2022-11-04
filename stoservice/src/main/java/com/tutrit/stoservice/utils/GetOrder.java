package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Order;

import java.util.HashMap;

public class GetOrder {

    private GetOrder() {
        throw new IllegalStateException("Utility class");
    }

    public static Order getOrder(String inputMsg) {
        HashMap<String, String> map;
        String[] keyAndSplit = getKey(inputMsg).split(":", 2);
        var object = getObject(inputMsg);
        if (object == null) {
            return makeOrder(new HashMap<>());
        }
        map = switch (keyAndSplit[0]) {
            case "json" -> objectToMapJson(object);
            case "m" ->
                    keyAndSplit.length > 1 ? objectToMap(object, keyAndSplit[1].substring(0, 1)) : objectToMap(object, " ");
            default -> new HashMap<>();
        };

        return makeOrder(map);
    }

    private static String getKey(String inputMsg) {
        if (inputMsg.contains("-") && inputMsg.contains("-d")) {
            return inputMsg.substring(inputMsg.indexOf('-') + 1, inputMsg.indexOf("-d")).trim();
        }
        return "null";
    }

    private static String getObject(String inputMsg) {
        if (inputMsg.contains("{") && inputMsg.contains("}")) {
            return inputMsg.substring(inputMsg.indexOf('{') + 1, inputMsg.indexOf('}'));
        }
        return null;
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

    private static Order makeOrder(HashMap<String, String> map) {
        var order = new Order();
        if (!map.isEmpty()) {
            order.setId("id");
            order.setUser(map.get("user"));
            order.setCar(map.get("car"));
            order.setOrderStatus(map.get("orderStatus"));
            return order;
        }
        return null;
    }
}
