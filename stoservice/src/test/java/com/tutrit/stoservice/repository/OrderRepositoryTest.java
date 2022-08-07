package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {
    OrderRepository orderRepository;
    Order order1;
    Order order2;
    Order order3;
    @BeforeEach
    void setUp() {
        order1 = new Order("1", "Vasil", "lada", "to do" );
        order2 = new Order("2", "Dima", "volga", "in progress" );
        order3 = new Order("3", "Petya", "patriot", "closed" );
        orderRepository = new OrderRepository();
        orderRepository.createOrder(order1);
        orderRepository.createOrder(order2);
        orderRepository.createOrder(order3);
    }

    @Test
    void createOrder() {
        Assertions.assertEquals(null, orderRepository.createOrder(order2));
        orderRepository.deleteOrder(order2);
        order2 = new Order("2", "Dima", "volga", "in progress" );
        Assertions.assertEquals(order2, orderRepository.createOrder(order2));
    }

    @Test
    void findOrder() {
        Order actual = orderRepository.findOrder(order2);
        Assertions.assertEquals(order2, actual);

    }

    @Test
    void findOrderById() {
        Order actual = orderRepository.findOrderById(order2.getId());
        Assertions.assertEquals(order2, actual);
    }

    @Test
    void updateOrder() {
        order2 = new Order("2", "sas", "sss", "OrderStatus.CLOSED" );
        orderRepository.updateOrder(order2);
        Order actual = orderRepository.findOrderById(order2.getId());
        Assertions.assertEquals(order2, actual);
    }

    @Test
    void deleteOrder() {
        Order order4 = new Order("4", "sas", "sss", "OrderStatus.CLOSED" );
        Assertions.assertFalse(orderRepository.deleteOrder(order4));
        Assertions.assertTrue(orderRepository.deleteOrder(order2));
    }

    @Test
    void deleteOrderById() {
        Order order4 = new Order("4", "sas", "sss", "OrderStatus.CLOSED" );
        Assertions.assertFalse(orderRepository.deleteOrderById(order4.getId()));
        Assertions.assertTrue(orderRepository.deleteOrderById(order2.getId()));
    }

    @Test
    void count() {
        Assertions.assertEquals(3, orderRepository.count());
        Assertions.assertTrue(4>orderRepository.count());
        orderRepository.deleteOrder(order2);
        Assertions.assertEquals(2, orderRepository.count());
    }

    @Test
    void validateOrder() {
        order2 = new Order("2", "sas", "sss", "OrderStatus.CLOSED" );
        orderRepository.updateOrder(order2);
        Order actual = orderRepository.findOrderById(order2.getId());
        Assertions.assertEquals(order2, actual);
    }
}
