package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;
import com.tutrit.stoservice.service.OrderService;

public class OrderServiceMock extends OrderService {

    Order capturedOrder;

    public OrderServiceMock() {
        super(null);
    }

    private OrderServiceMock(OrderRepository orderRepository) {
        super(null);
    }

    @Override
    public void saveOrder(Order order) {
        capturedOrder = order;
    }
}
