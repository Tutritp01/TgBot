package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderProvider {
    private OrderProvider(){
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }

    static Map<Object, Object> getOrders() {
        Map<Object, Object> initialOrders = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            initialOrders.put(getInstance(i).getId(), getInstance(i));
        }
        return initialOrders;
    }

    static Order getInstance(int i) {
        return new Order("Id" + i, "User" + i, "Car" + i, "Open" + i);
    }

    static Order getInstance() {
        return new Order("Id", "User", "Car", "Open");
    }
}
