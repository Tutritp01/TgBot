package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.Repository;

public class OrderService {
    Repository<Order, String> repository;

    public OrderService() {
    }

    public OrderService(final Repository<Order, String> repository) {
        this.repository = repository;
    }

    public void saveOrder(Order order) {
        repository.save(order);
    }

    public Order findById(String id) {
        return repository.findById(id);
    }
}
