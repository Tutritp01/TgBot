package com.tutrit.stoservice.service.mock;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;

public class OrderRepositoryMock extends OrderRepository {
    Order order = new Order("1", "Vasil", "lada", "to do");

    @Override
    public Order save(Order order) {
        order.setId("1");
        orders.put("1", order);
        return this.order;
    }

    @Override
    public Order findById(String id) {
        return order;
    }
}
