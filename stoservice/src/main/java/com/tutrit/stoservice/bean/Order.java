package com.tutrit.stoservice.bean;





import java.util.Objects;

public class Order {
    private String id;
    private String user;
    private String car;
    private String orderStatus;

    public Order() {
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
        return id == order.id && user.equals(order.user) && car.equals(order.car) && orderStatus.equals(order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, car, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", car='" + car + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
