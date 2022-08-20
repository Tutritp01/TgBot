package com.tutrit.stoservice.repository;


import com.tutrit.stoservice.bean.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    public static Map<String, Order> orders = new HashMap<>();

    public Order createOrder(Order order) {
        if (!orders.containsKey(order.getId())) {
            return orders.put(order.getId(), order);
        }
        return null;
    }

    public Order findOrder(Order order) {
        String id = order.getId();
        for (String key : orders.keySet()) {
            if (key.equals(id)) {
                return orders.get(id);
            }
        }
        return null;
    }

    public Order findOrderById(String id) {
        for (String key : orders.keySet()) {
            if (key.equals(id)) {
                return orders.get(id);
            }
        }
        return null;
    }

    public Order updateOrder(Order order) {
        for (String key : orders.keySet()) {
            if (key.equals(order.getId())) {
                return orders.put(order.getId(), order);
            }
        }
        logger.info("object cannot be updated, but maybe we can create a new object.");
        return null;
    }

    public boolean deleteOrder(Order order) {
        return Objects.nonNull(orders.remove(order.getId()));
    }

    public boolean deleteOrderById(String id) {
        for (String key : orders.keySet()) {
            if (key.equals(id)) {
                return Objects.nonNull(orders.remove(id));
            }
        }
        logger.info("there is no such key in the map :(");
        return false;
    }

    public int count() {
        return orders.size();
    }
}
