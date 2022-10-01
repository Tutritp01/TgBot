package com.tutrit.stoservice.context;

import com.tutrit.stoservice.controller.*;
import com.tutrit.stoservice.provider.CarProvider;
import com.tutrit.stoservice.provider.CustomerProvider;
import com.tutrit.stoservice.repository.*;
import com.tutrit.stoservice.service.UserService;

import java.util.Map;

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

        put(DataController.class, new DataController());
        put(ExitController.class, new ExitController());
        put(HelpController.class, new HelpController());
        put(NotACommandController.class, new NotACommandController());
        put(UserController.class, new UserController(get(UserService.class)));

        Map<Command, CommandController> commandCommandControllerMap = Map.of(
                get(DataController.class).getCommand(), get(DataController.class),
                get(ExitController.class).getCommand(), get(ExitController.class),
                get(HelpController.class).getCommand(), get(HelpController.class),
                get(NotACommandController.class).getCommand(), get(NotACommandController.class),
                get(UserController.class).getCommand(), get(UserController.class)
        );

        put(CarProvider.class, new CarProvider());
        put(CustomerProvider.class, new CustomerProvider());

        put(RequestDispatcher.class, new RequestDispatcher());
    }
}
