package com.tutrit.tgbot.example.repository;

import com.tutrit.tgbot.example.bean.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    private static final Map<Long, Order> orders = new HashMap();

    public static Order createOrder(Order order){
        orders.put(order.getId(), order);
        return order;
    }

    public static Order getOrderById(Long id){
        orders.forEach((k, v) ->
                logger.info("Key: " + k + " Value: " + v));
                    return orders.get(id);
        }

    public static void deleteOrder(Order order){
        orders.remove(order.getId());
    }

    public static void updateOrder(Order order){
        orders.put(order.getId(), order);
    }

    public static String readOrder(Order order){
        orders.put(order.getId(), order);
        return orders.toString();
    }
}
