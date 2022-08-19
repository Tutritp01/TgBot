package com.tutrit.stoservice;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.provider.*;
import com.tutrit.stoservice.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class StoserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoserviceApplication.class, args);

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
        Map<Object, Object> orders = OrderProvider.getOrders(5);
        for (Object order : orders.values()) {
            orderRepository.createOrder((Order) order);
        }

        UserRepository userRepository = new UserRepository();
        Map<String, Object> userMap = UserProvider.getUsers(5);
        for (Object user : userMap.values()) {
            userRepository.createUser((User) user);
        }
    }
}
