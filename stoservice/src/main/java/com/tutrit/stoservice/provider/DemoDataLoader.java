package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.repository.*;

import java.util.Map;

public class DemoDataLoader {

    public void run() {
        CarProvider carProvider = new CarProvider();
        CarRepository.cars.addAll(carProvider.getCar());

        CustomerProvider customerProvider = new CustomerProvider();
        CustomerRepository.customers.addAll(customerProvider.getCustomers(5));

        EngineerRepository engineerRepository = new EngineerRepository();
        Engineer[] engineers = EngineerProvider.getEngineers(5);
        for (int i = 0; i < 5; i++) {
            engineerRepository.createEngineer(engineers[i]);
        }

        OrderRepository orderRepository = new OrderRepository();
        Map<Object, Object> orders = OrderProvider.getOrders();
        for (Object order : orders.values()) {
            orderRepository.createOrder((Order) order);
        }

        UserRepository userRepository = new UserRepository();
        Map<String, Object> userMap = UserProvider.getUsers(5);
        for (Object user : userMap.values()) {
            userRepository.save((User) user);
        }
    }
}
