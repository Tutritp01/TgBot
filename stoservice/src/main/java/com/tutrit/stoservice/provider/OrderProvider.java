package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;

public class OrderProvider {
    OrderRepository orderRepository;

    Order getOrder(Order order, int i) {
        order.setId("id" + i);
        order.setUser("UserName");
        order.setCar("UserCar");
        order.setOrderStatus("Open");
        return order;
    }

    void createTenOrder() {
        for (int i = 1; i < 11; i++) {
            Order order = new Order();
            order = getOrder(order, i);
            orderRepository.createOrder(order);
        }
    }
}
