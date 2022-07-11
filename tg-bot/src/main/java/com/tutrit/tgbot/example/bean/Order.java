package com.tutrit.tgbot.example.bean;

import com.tutrit.tgbot.example.constants.OrderStatus;

import java.util.Objects;

public class Order {
    private long id;
    private User user;
    private Car car;
    private OrderStatus orderStatus;
    public Order(long id, User user, Car car, OrderStatus orderStatus) {
        this.id = id;
        this.user = user;
        this.car = car;
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
