package com.tutrit.stoservice.context;


import com.tutrit.stoservice.controller.*;
import com.tutrit.stoservice.provider.CarProvider;
import com.tutrit.stoservice.provider.CustomerProvider;
import com.tutrit.stoservice.repository.*;
import com.tutrit.stoservice.service.CustomerService;
import com.tutrit.stoservice.utils.GetCustomer;
import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.service.CarService;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static com.tutrit.stoservice.context.ApplicationContext.put;

public class ApplicationContextLoader {

    private ApplicationContextLoader() {
        throw new IllegalStateException("Utility class");
    }

    public static void run() {
        put(CarRepository.class, new CarRepository());
        put(CustomerRepository.class, new CustomerRepository());
        put(EngineerRepository.class, new EngineerRepository());
        put(OrderRepository.class, new OrderRepository());
        put(UserRepository.class, new UserRepository());
        put(UserService.class, new UserService(get(UserRepository.class)));

        put(CarService.class, new CarService(get(CarRepository.class)));

        put(DataController.class, new DataController());
        put(ExitController.class, new ExitController());
        put(HelpController.class, new HelpController());
        put(NotACommandController.class, new NotACommandController());
        put(UserController.class, new UserController(get(UserService.class)));
        put(CarController.class, new CarController(get(CarService.class)));

        put(CustomerService.class, new CustomerService(get(CustomerRepository.class)));
        put(CustomerController.class, new CustomerController(get(CustomerService.class)));

        put(GetCustomer.class, new GetCustomer());
        put(CarProvider.class, new CarProvider());
        put(CustomerProvider.class, new CustomerProvider());


        put(RequestDispatcher.class, new RequestDispatcher());

    }
}
