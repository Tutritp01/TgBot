package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Order;

import java.util.Map;

public class UserInputToOrder {

    private UserInputToOrder() {
        throw new IllegalStateException("Utility class");
    }

    public static Order getOrder(String inputMsg) {
        Map<String, String> map = GetMap.getMap(inputMsg);
        return makeOrder(map);
    }

    private static Order makeOrder(Map<String, String> map) {
        var order = new Order();
        if (!map.isEmpty()) {
            order.setUser(map.get("user"));
            order.setCar(map.get("car"));
            order.setOrderStatus(map.get("orderStatus"));
            return order;
        }
        return null;
    }
}
