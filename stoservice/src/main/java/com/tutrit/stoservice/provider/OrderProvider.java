package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;

public class OrderProvider {
    private OrderProvider() {
    }

    public static Order getOrder(Order order, int i) {
        order.setId("id" + i);
        order.setUser("UserName");
        order.setCar("UserCar");
        order.setOrderStatus("Open");
        return order;
    }

    static OrderRepository createTenOrder() {
        OrderRepository orderRepository = new OrderRepository();
        for (int i = 1; i < 11; i++) {
            Order order = new Order();
            getOrder(order, i);
            orderRepository.createOrder(order);
        }
        return orderRepository;
    }
}
