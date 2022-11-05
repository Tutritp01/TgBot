package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderRepository implements Repository<Order, String> {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    public static Map<String, Order> orders = new HashMap<>();
    public static int counted = 0;

    @Override
    public Order save(Order order) {
        if (!orders.containsKey(order.getId())) {
            return orders.put(Integer.toString(count()), order);
        }
        return null;
    }

    @Override
    public void saveAll(Iterable<Order> ordersMap) {
        for (Order order : ordersMap) {
            orders.put(order.getId(), order);
        }
    }

    @Override
    public Order find(Order order) {
        String id = order.getId();
        for (String key : orders.keySet()) {
            if (key.equals(id)) {
                return orders.get(id);
            }
        }
        return null;
    }

    @Override
    public Iterable<Order> findAll() {
        return orders.values();
    }

    @Override
    public Order findById(String id) {
        for (String key : orders.keySet()) {
            if (key.equals(id)) {
                return orders.get(id);
            }
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        for (String key : orders.keySet()) {
            if (key.equals(order.getId())) {
                return orders.put(order.getId(), order);
            }
        }
        logger.info("object cannot be updated, but maybe we can create a new object.");
        return null;
    }

    @Override
    public boolean delete(Order order) {
        return Objects.nonNull(orders.remove(order.getId()));
    }

    @Override
    public boolean deleteById(String id) {
        for (String key : orders.keySet()) {
            if (key.equals(id)) {
                return Objects.nonNull(orders.remove(id));
            }
        }
        logger.info("there is no such key in the map :(");
        return false;
    }

    @Override
    public int count() {
        counted++;
        return counted;
    }
}
