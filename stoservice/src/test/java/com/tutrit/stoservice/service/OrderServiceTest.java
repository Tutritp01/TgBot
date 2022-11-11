package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;
import com.tutrit.stoservice.service.mock.OrderRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    OrderService orderService;
    OrderRepository orderRepository;
    Order expected;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepositoryMock();
        orderService = new OrderService(orderRepository);
        expected = new Order("1", "Vasil", "lada", "to do");
    }

    @Test
    void saveOrder() {
        orderService.saveOrder(new Order("1", "Vasil", "lada", "to do"));
        assertEquals(expected, orderRepository.orders.get("1"));
    }

    @Test
    void findById() {
        assertEquals(expected, orderService.findById("id"));
    }
}
