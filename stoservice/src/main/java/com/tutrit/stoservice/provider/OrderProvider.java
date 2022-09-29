package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProvider {
    private OrderProvider(){
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }

    public static List<Order> getOrders() {
        List<Order> initialOrders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Order order = getInstance(i);
            initialOrders.add(order);
        }
        return initialOrders;
    }

    public static List<Order> getOrders(int amount) {
        List<Order> initialOrders = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Order order = getInstance(i);
            initialOrders.add(order);
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
