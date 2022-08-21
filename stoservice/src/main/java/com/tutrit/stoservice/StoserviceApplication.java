package com.tutrit.stoservice;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.provider.*;
import com.tutrit.stoservice.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class StoserviceApplication {
    private static final Logger log = LoggerFactory.getLogger("main");

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
        Map<Object, Object> orders = OrderProvider.getOrders();
        for (Object order : orders.values()) {
            orderRepository.createOrder((Order) order);
        }

        UserRepository userRepository = new UserRepository();
        Map<String, Object> userMap = UserProvider.getUsers(5);
        for (Object user : userMap.values()) {
            userRepository.createUser((User) user);
        }

        log.info("""
                Command List:
                1 - Show data
                0 - Exit
                """);

        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        switch (i) {
            case 1:
                printLoadData(engineerRepository);
                break;
            case 0:
                break;
            default:
                log.info("Wrong command");
                break;
        }
    }

    private static void printLoadData(EngineerRepository engineerRepo) {
        CarRepository.cars.forEach(car -> log.info(car.toString()));
        CustomerRepository.customers.forEach(customer -> log.info(customer.toString()));
        try {
            for (Engineer engineer : engineerRepo.engineers) {
                String message = engineer.toString();
                 log.info(message);
            }
        } catch (Exception err) {
            //not print Exception
        }
        OrderRepository.orders.forEach((orderK, orderV) -> log.info("Key: {}. Value: {}", orderK, orderV));
        UserRepository.userMap.forEach((userK, userV) -> log.info("Key: {}. Value: {}", userK, userV));
    }
}
