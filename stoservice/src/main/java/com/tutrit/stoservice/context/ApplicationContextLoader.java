package com.tutrit.stoservice.context;


import com.tutrit.stoservice.controller.*;
import com.tutrit.stoservice.provider.CarProvider;
import com.tutrit.stoservice.provider.CustomerProvider;
import com.tutrit.stoservice.repository.*;
import com.tutrit.stoservice.service.*;
import com.tutrit.stoservice.settings.Configurations;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static com.tutrit.stoservice.context.ApplicationContext.put;

public class ApplicationContextLoader {

    private ApplicationContextLoader() {
        throw new IllegalStateException("Utility class");
    }

    public static void run() {
        put(Configurations.class, new Configurations("src/main/resources/config.properties"));
        put(CarRepository.class, new CarRepository());
        put(CustomerRepository.class, new CustomerRepository());
        put(EngineerRepository.class, new EngineerRepository());
        put(OrderRepository.class, new OrderRepository());
        put(UserRepository.class, new UserRepository());
        put(MessageRepository.class, new MessageRepository());
        put(UserMessageRepository.class, new UserMessageRepository());
        put(PromoRepository.class, new PromoRepository());

        put(UserService.class, new UserService(get(UserRepository.class)));
        put(EngineerService.class, new EngineerService(get(EngineerRepository.class)));
        put(CarService.class, new CarService(get(CarRepository.class)));
        put(CustomerService.class, new CustomerService(get(CustomerRepository.class)));
        put(OrderService.class, new OrderService(get(OrderRepository.class)));
        put(MessageService.class, new MessageService(get(MessageRepository.class)));
        put(PromoService.class, new PromoService(get(PromoRepository.class)));

        put(CustomerController.class, new CustomerController(get(CustomerService.class)));
        put(UserController.class, new UserController(get(UserService.class),
                get(MessageService.class),
                get(PromoService.class)));
        put(CarController.class, new CarController(get(CarService.class)));
        put(EngineerController.class, new EngineerController(get(EngineerService.class)));
        put(OrderController.class, new OrderController(get(OrderService.class)));

        put(DataController.class, new DataController(get(CarRepository.class),
                get(CustomerRepository.class),
                get(OrderRepository.class),
                get(UserRepository.class),
                get(EngineerRepository.class)));
        put(ExitController.class, new ExitController());
        put(HelpController.class, new HelpController());
        put(NotACommandController.class, new NotACommandController());

        put(CarProvider.class, new CarProvider());
        put(CustomerProvider.class, new CustomerProvider());

        put(RequestDispatcher.class, new RequestDispatcher());
    }
}
