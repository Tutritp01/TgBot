package com.tutrit.stoservice.service.mock;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;

public class OrderRepositoryMock extends OrderRepository {
    @Override
    public Order save(Order order) {
        return new Order("1", "Vasil", "lada", "to do");
    }
}
