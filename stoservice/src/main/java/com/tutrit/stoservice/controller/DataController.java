package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.repository.*;

public class DataController implements CommandController {
    private static final Command command = Command.SHOW_DATA;

    CarRepository carRepository;
    CustomerRepository customerRepository;
    OrderRepository orderRepository;
    UserRepository userRepository;
    EngineerRepository engineerRepository;

    public DataController(final CarRepository carRepository,
                          final CustomerRepository customerRepository,
                          final OrderRepository orderRepository,
                          final UserRepository userRepository,
                          final EngineerRepository engineerRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.engineerRepository = engineerRepository;
    }

    public void doCommand(Request request, Response response) {
        response.setResponse(String.format(this.loadedDataAsString()));
    }

    private String loadedDataAsString() {
        StringBuilder rs = new StringBuilder();

        carRepository.findAll().forEach(car -> rs.append("\n").append(car.toString()));
        customerRepository.findAll().forEach(customer -> rs.append("\n").append(customer.toString()));
        orderRepository.findAll().forEach(order -> rs.append("\n").append(order.toString()));
        userRepository.findAll().forEach(user -> rs.append("\n").append(user.toString()));
        engineerRepository.findAll().forEach(engineer -> rs.append("\n").append(engineer.toString()));

        return rs.toString();
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
