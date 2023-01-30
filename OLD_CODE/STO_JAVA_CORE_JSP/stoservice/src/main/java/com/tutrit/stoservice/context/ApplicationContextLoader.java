package com.tutrit.stoservice.context;


import com.tutrit.stoservice.controller.*;
import com.tutrit.stoservice.provider.CarProvider;
import com.tutrit.stoservice.provider.CustomerProvider;
import com.tutrit.stoservice.repository.*;
import com.tutrit.stoservice.service.*;
import com.tutrit.stoservice.settings.ArgsSetup;
import com.tutrit.stoservice.settings.Configurations;

import static com.tutrit.stoservice.context.ApplicationContext.loadClass;
import static com.tutrit.stoservice.context.ApplicationContext.put;

public class ApplicationContextLoader {

    private ApplicationContextLoader() {
        throw new IllegalStateException("Utility class");
    }

    public static void run() {
        put(Configurations.class, new Configurations("src/main/resources/config.properties"));
        put(ArgsSetup.class, new ArgsSetup(loadClass(Configurations.class)));
        put(CarRepository.class, new CarRepository());
        put(CustomerRepository.class, new CustomerRepository());
        put(EngineerRepository.class, new EngineerRepository());
        put(OrderRepository.class, new OrderRepository());
        put(UserRepository.class, new UserRepository());
        put(MessageRepository.class, new MessageRepository());
        put(UserMessageRepository.class, new UserMessageRepository());
        put(PromoRepository.class, new PromoRepository());

        put(UserService.class, new UserService(loadClass(UserRepository.class)));
        put(EngineerService.class, new EngineerService(loadClass(EngineerRepository.class)));
        put(CarService.class, new CarService(loadClass(CarRepository.class)));
        put(CustomerService.class, new CustomerService(loadClass(CustomerRepository.class)));
        put(OrderService.class, new OrderService(loadClass(OrderRepository.class)));
        put(MessageService.class, new MessageService(loadClass(MessageRepository.class)));
        put(PromoService.class, new PromoService(loadClass(PromoRepository.class)));

        put(CustomerController.class, new CustomerController(loadClass(CustomerService.class)));
        put(UserController.class, new UserController(loadClass(UserService.class),
                loadClass(MessageService.class),
                loadClass(PromoService.class)));
        put(CarController.class, new CarController(loadClass(CarService.class)));
        put(EngineerController.class, new EngineerController(loadClass(EngineerService.class)));
        put(OrderController.class, new OrderController(loadClass(OrderService.class)));

        put(DataController.class, new DataController(loadClass(CarRepository.class),
                loadClass(CustomerRepository.class),
                loadClass(OrderRepository.class),
                loadClass(UserRepository.class),
                loadClass(EngineerRepository.class)));
        put(ExitController.class, new ExitController());
        put(HelpController.class, new HelpController());
        put(NotACommandController.class, new NotACommandController());

        put(CarProvider.class, new CarProvider());
        put(CustomerProvider.class, new CustomerProvider());

        put(RequestDispatcher.class, new RequestDispatcher());
        put(InMemoryAuthenticationService.class, new InMemoryAuthenticationService());
    }
}
