package com.tutrit.stoservice.bean;

import com.tutrit.stoservice.mapper.MapTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private static final Logger log = LoggerFactory.getLogger("order");

    private String id;
    @MapTo
    private Customer customer;
    @MapTo
    private User user;
    @MapTo
    private Car car;
    private List<Engineer> engineers = new ArrayList<>();

    private String orderStatus;

    public Order(){}

    public Order(String id, String user, String car, String open) {
    }

    public Order(String id, Customer customer, User user, Car car, Engineer engineer, String orderStatus) {
        this.id = id;
        this.customer = customer;
        this.user = user;
        this.car = car;
        try {
            this.engineers.add(engineer);
        } catch (Exception e) {
            log.debug("Error adding engineer to order");
        }
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

    public List<Engineer> getEngineers() {
        return engineers;
    }

    public void setEngineers(List<Engineer> engineers) {
        this.engineers = engineers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
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
        return Objects.equals(id, order.id) && Objects.equals(customer, order.customer) && Objects.equals(user, order.user) && Objects.equals(car, order.car) && Objects.equals(engineers, order.engineers) && Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, user, car, engineers, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", user=" + user +
                ", car=" + car +
                ", engineers=" + engineers +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
