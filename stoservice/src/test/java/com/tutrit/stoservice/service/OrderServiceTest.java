package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;
import com.tutrit.stoservice.service.mock.OrderRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    OrderRepository orderRepository;
    Order expected;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepositoryMock();
        expected = new Order("1", "Vasil", "lada", "to do");
    }

    @Test
    void saveOrder() {
        assertEquals(expected, orderRepository.save(new Order()));
    }
}