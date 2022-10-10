package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;

public class OrderService {

    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
