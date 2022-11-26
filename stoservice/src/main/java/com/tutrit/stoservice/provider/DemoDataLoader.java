package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.repository.*;

public class DemoDataLoader {

    public void run() {
        CarProvider carProvider = ApplicationContext.get(CarProvider.class);
        CarRepository carRepository = ApplicationContext.get(CarRepository.class);
        carRepository.saveAll(carProvider.getCar());

        CustomerProvider customerProvider = ApplicationContext.get(CustomerProvider.class);
        CustomerRepository customerRepository = ApplicationContext.get(CustomerRepository.class);
        customerRepository.saveAll(customerProvider.getCustomers(5));

        EngineerRepository engineerRepository = ApplicationContext.get(EngineerRepository.class);
        Engineer[] engineers = EngineerProvider.getEngineers(5);
        for (int i = 0; i < 5; i++) {
            engineerRepository.save(engineers[i]);
        }

        OrderRepository orderRepository = ApplicationContext.get(OrderRepository.class);
        orderRepository.saveAll(OrderProvider.getOrders(5));

        UserRepository userRepository = ApplicationContext.get(UserRepository.class);
        userRepository.saveAll(UserProvider.getUsers(5));

        MessageProvider.getMessages();
    }
}
