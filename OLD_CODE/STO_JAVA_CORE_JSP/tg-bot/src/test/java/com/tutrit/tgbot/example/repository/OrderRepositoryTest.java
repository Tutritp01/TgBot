package com.tutrit.tgbot.example.repository;

import com.tutrit.tgbot.example.bean.Car;
import com.tutrit.tgbot.example.bean.Order;
import com.tutrit.tgbot.example.bean.User;
import com.tutrit.tgbot.example.constants.OrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class OrderRepositoryTest {




    @org.junit.jupiter.api.Test
    void deleteOrder() {
        OrderRepository orderRepository = new OrderRepository();
        Order order1 = new Order(1, null, null, OrderStatus.IN_PROGRESS );
        Order order2 = new Order(2, null, null, OrderStatus.ORDER_COMPLETE );
        Order order3 = new Order(3, null, null, OrderStatus.CLOSED );
        orderRepository.createOrder(order1);
        orderRepository.createOrder(order2);
        orderRepository.createOrder(order3);
        Assertions.assertEquals(order2, OrderRepository.getOrderById(order2.getId()));
        orderRepository.deleteOrder(order2);
        Assertions.assertEquals(null, OrderRepository.getOrderById(order2.getId()));
    }

    @org.junit.jupiter.api.Test
    void testCreateOrder() {
        OrderRepository orderRepository = new OrderRepository();
        User user = new User();
        Car car = new Car();
        Order order = new Order(123, user, car, OrderStatus.IN_PROGRESS );

        Order result = orderRepository.createOrder(order);

        Assertions.assertEquals(order, result);
        Assertions.assertEquals(order, OrderRepository.getOrderById(order.getId()));
    }

    @Test
    void updateOrder() {
        OrderRepository orderRepository = new OrderRepository();
        Order order1 = new Order(1, null, null, OrderStatus.IN_PROGRESS );
        Order order2 = new Order(2, null, null, OrderStatus.ORDER_COMPLETE );
        Order order3 = new Order(3, null, null, OrderStatus.CLOSED );
        orderRepository.createOrder(order1);
        orderRepository.createOrder(order2);
        orderRepository.createOrder(order3);
        order2 = new Order(2, new User(), new Car(), OrderStatus.CLOSED );
        orderRepository.updateOrder(order2);
        Assertions.assertEquals(order2, OrderRepository.getOrderById(order2.getId()));
    }

    @Test
    void readOrder() {
        OrderRepository orderRepository = new OrderRepository();
        Order order1 = new Order(1, null, null, OrderStatus.IN_PROGRESS );
        Map<Long, Order> result = new HashMap<>();
        result.put(order1.getId(), order1);
        Assertions.assertEquals(result.toString(), orderRepository.readOrder(order1));
    }
}