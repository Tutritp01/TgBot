package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.*;

import java.util.ArrayList;
import java.util.List;

public class OrderProvider {
    private OrderProvider() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Order> getOrders() {
        List<Order> initialOrders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Order order = getInstance(i);
            initialOrders.add(order);
        }
        return initialOrders;
    }

    public static List<Order> getOrders(int amount) {
        List<Order> initialOrders = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Order order = getInstance(i);
            initialOrders.add(order);
        }
        return initialOrders;
    }

    static Order getInstance(int i) {
        Order order = new Order();
        Engineer engineer = new Engineer(Integer.toString(i), "firstName" + i, "lastName" + i, "function" + i, "category" + i, "education" + i, 10 + Integer.valueOf(i), Integer.valueOf(i));
        Car car = new Car(Integer.toString(i), "owner1" + i, "vin1" + i, "plateNumber1" + i, "brand1" + i, "model1" + i, "1g" + i, "mod1" + i, "engine1" + i, 2000 + Integer.valueOf(i));
        Customer customer = new Customer(Integer.toString(i), "customer1" + i, "city1" + i, "phoneNumber1" + i, "email1" + i);
        order.setId(Integer.toString(i));
        order.setOrderStatus("new");
        order.setCar(car);
        order.setCustomer(customer);
        order.setEngineers(List.of(engineer));
        return order;
    }

    static Order getInstance() {
        Order order = new Order();
        Engineer engineer = new Engineer("id", "firstName" , "lastName" , "function", "category", "education", 10 , 5);
        Car car = new Car("id", "owner1", "vin1" , "plateNumber1", "brand1" , "model1", "1g", "mod1", "engine1" , 2000);
        Customer customer = new Customer("id", "customer1" , "city1" , "phoneNumber1" , "email1");
        order.setId("id");
        order.setOrderStatus("new");
        order.setCar(car);
        order.setCustomer(customer);
        order.setEngineers(List.of(engineer));
        return order;

    }

    public static List<Order> getFiveRealOrder() {
        List<Order> initialOrders = new ArrayList<>();
        var car1 = new Car("1", "Alex", "X1213141516ABCDEF", "1122-KM1", "Tesla", "X", "I", "XL", "600kW", 2016);
        var car2 = new Car("2", "Yura", "X1314151617ABCDEF", "2233-KM1", "Tesla", "S", "II", "L", "800kW", 2018);
        var car3 = new Car("3", "Vladik", "X1415161718ABCDEF", "3344-KM1", "Tesla", "3", "III", "M", "900kW", 2020);
        var car4 = new Car("4", "Maxim", "X1920212223ABCDEF", "4455-MM1", "Tesla", "X", "IV", "S", "1000kW", 2021);
        var car5 = new Car("5", "Vladimir", "X2021222324ABCDEF", "7777-KM1", "Tesla", "S", "V", "XS", "1200kW", 2022);
        var engineer1 = new Engineer("1", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        var engineer2 = new Engineer("2", "Денис", "Пелля", "Мастер цеха", "высшая", "высшее", 3, 7);
        var engineer3 = new Engineer("3", "Юрий", "Божко", "Главный инжинер", "высшая", "высшее", 1, 10);
        var engineer4 = new Engineer("4", "Роман", "Валюшко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        var engineer5 = new Engineer("5", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);
        var user1 = new User("1", "User", "375251122334");
        var user2 = new User("2", "User", "375252233445");
        var user3 = new User("3", "User", "375253344556");
        var user4 = new User("4", "User", "375254455667");
        var user5 = new User("5", "User", "375255566778");
        var customer1 = new Customer("1", "Name", "Brest", "375251122334", "First@gmail.com");
        var customer2 = new Customer("2", "Name", "Minsk", "375252233445", "Second@gmail.com");
        var customer3 = new Customer("3", "Name", "Beresa", "375253344556", "Third@gmail.com");
        var customer4 = new Customer("4", "Name", "Polotsk", "375254455667", "Fourth@gmail.com");
        var customer5 = new Customer("5", "Name", "Vitebsk", "375255566778", "Fifth@gmail.com");
        initialOrders.add(new Order("10", customer1, user1, car1, engineer1, "open"));
        initialOrders.add(new Order("11", customer2, user2, car2, engineer2, "open"));
        initialOrders.add(new Order("12", customer3, user3, car3, engineer3, "open"));
        initialOrders.add(new Order("13", customer4, user4, car4, engineer4, "open"));
        initialOrders.add(new Order("14", customer5, user5, car5, engineer5, "open"));
        return initialOrders;
    }
}
