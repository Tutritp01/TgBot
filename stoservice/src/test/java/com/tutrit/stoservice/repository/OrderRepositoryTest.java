package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {
    OrderRepository orderRepository;
    Order order1;
    Order order2;
    Order order3;
    @BeforeEach
    void setUp() {
        order1 = new Order("1", "Vasil", "lada", "to do");
        order2 = new Order("2", "Dima", "volga", "in progress");
        order3 = new Order("3", "Petya", "patriot", "closed");
        orderRepository = new OrderRepository();
        orderRepository.counted = 0;
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
    }

    @Test
    void save() {
        var order4 = new Order("", "Dima", "volga", "closed" );
        orderRepository.save(order4);
        assertEquals(4, orderRepository.orders.size());
        var order5 = new Order("", "Santa", "volga", "to do" );
        orderRepository.save(order5);
        assertEquals(5, orderRepository.orders.size());
    }

    @Test
    void saveAll() {
        var order4 = new Order("", "Vasil", "lada", "to do" );
        var order5 = new Order("", "Dima", "volga", "in progress" );
        var order6 = new Order("", "Petya", "patriot", "closed" );
        var order7 = new Order("", "Vika", "kadet", "to do" );
        List<Order> ordersList = new ArrayList<>();
        ordersList.add(order4);
        ordersList.add(order5);
        ordersList.add(order6);
        ordersList.add(order7);
        orderRepository.saveAll(ordersList);
        assertEquals(7, orderRepository.orders.size());
    }

    @Test
    void find() {
        Order actual = orderRepository.find(order2);
        Assertions.assertEquals(order2, actual);
    }

    @Test
    void findAll() {
        Map<String, Order> orderMap = Map.of(
            "1", new Order("1", "Vasil", "lada", "to do" ),
            "2", new Order("2", "Dima", "volga", "in progress" ),
            "3", new Order("3", "Petya", "patriot", "closed" )
        );

        final Map<String, Order> actualResult = StreamSupport
                .stream(orderRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(Order::getId, el -> el));

        assertEquals(orderMap, actualResult);
    }

    @Test
    void findById() {
        Order actual1 = orderRepository.findById(order1.getId());
        Order actual2 = orderRepository.findById(order2.getId());
        Order actual3 = orderRepository.findById("3");
        Assertions.assertEquals(order1, actual1);
        Assertions.assertEquals(order2, actual2);
        Assertions.assertEquals(order3, actual3);
    }

    @Test
    void delete() {
        Order order4 = new Order("4", "sas", "sss", "OrderStatus.CLOSED" );
        Assertions.assertFalse(orderRepository.delete(order4));
        Assertions.assertTrue(orderRepository.delete(order2));
    }

    @Test
    void deleteById() {
        Order order4 = new Order("4", "sas", "sss", "OrderStatus.CLOSED" );
        Assertions.assertFalse(orderRepository.deleteById(order4.getId()));
        Assertions.assertTrue(orderRepository.deleteById(order2.getId()));
    }
    @Test
    void update() {
        order2 = new Order("2", "sas", "sss", "OrderStatus.CLOSED" );
        orderRepository.update(order2);
        Order actual = orderRepository.findById(order2.getId());
        Assertions.assertEquals(order2, actual);
        order2 = new Order("2", "Dima", "volga", "in progress" );
        orderRepository.update(order2);
    }
    @Test
    void count() {
        Assertions.assertEquals(3, orderRepository.count());
        Assertions.assertTrue(4>orderRepository.count());
        orderRepository.delete(order2);
        Assertions.assertEquals(2, orderRepository.count());
    }
}
