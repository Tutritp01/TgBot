package com.tutrit.stoservice.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private static final Logger log = LoggerFactory.getLogger("order");

    private String id;
    private Customer customer;
    private User userField;
    private Car carField;
    private List<Engineer> engineers = new ArrayList<>();
    private String user;
    private String car;
    private String orderStatus;

    public Order() {
    }

    public Order(String id, Customer customer, User userField, Car carField, Engineer engineer, String user, String car, String orderStatus) {
        this.id = id;
        this.customer = customer;
        this.userField = userField;
        this.carField = carField;
        try {
            this.engineers.add(engineer);
        } catch (Exception e) {
            log.debug("Error adding engineer to order");
        }
        this.user = user;
        this.car = car;
        this.orderStatus = orderStatus;
    }

    public Order(String id, String user, String car, String orderStatus) {
        this.id = id;
        this.user = user;
        this.car = car;
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUserField() {
        return userField;
    }

    public void setUserField(User userField) {
        this.userField = userField;
    }

    public Car getCarField() {
        return carField;
    }

    public void setCarField(Car carField) {
        this.carField = carField;
    }

    public List<Engineer> getEngineers() {
        return engineers;
    }

    public void setEngineers(List<Engineer> engineers) {
        this.engineers = engineers;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(customer, order.customer) && Objects.equals(userField, order.userField) && Objects.equals(carField, order.carField) && Objects.equals(engineers, order.engineers) && Objects.equals(user, order.user) && Objects.equals(car, order.car) && Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, userField, carField, engineers, user, car, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", userField=" + userField +
                ", carField=" + carField +
                ", engineers=" + engineers +
                ", user='" + user + '\'' +
                ", car='" + car + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
