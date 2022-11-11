package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.*;

public class DemoDataLoader {

    public void run() {
        CarProvider carProvider = new CarProvider();
        CarRepository carRepository = new CarRepository();
        carRepository.saveAll(carProvider.getCar());

        CustomerProvider customerProvider = new CustomerProvider();
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveAll(customerProvider.getCustomers(5));

        EngineerRepository engineerRepository = new EngineerRepository();
        Engineer[] engineers = EngineerProvider.getEngineers(5);
        for (int i = 0; i < 5; i++) {
            engineerRepository.save(engineers[i]);
        }

        OrderRepository orderRepository = new OrderRepository();
        orderRepository.saveAll(OrderProvider.getOrders(5));

        UserRepository userRepository = new UserRepository();
        userRepository.saveAll(UserProvider.getUsers(5));

        MessageProvider.getMessages();
    }
}
