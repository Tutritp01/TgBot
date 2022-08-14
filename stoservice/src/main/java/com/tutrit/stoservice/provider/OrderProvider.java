package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderProvider {
    private final Map<Object, Object> initialOrders = new HashMap<>();
    Map<Object, Object> getOrders() {
        for (int i = 0; i < 10; i++) {
            getInstance(i);
            initialOrders.put(getInstance(i).getId(), getInstance(i));
        }
        return initialOrders;
    }

    Order getInstance(int i) {
       return new Order("Id" + i, "User" + i, "Car" + i, "Open" + i);
    }
}
