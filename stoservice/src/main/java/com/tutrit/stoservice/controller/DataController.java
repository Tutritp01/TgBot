package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.repository.*;

public class DataController implements CommandController {
    private static final Command command = Command.SHOW_DATA;

    public void doCommand(Request request, Response response) {
        response.setResponse(String.format(this.loadedDataAsString()));
    }

    private String loadedDataAsString() {
        StringBuilder rs = new StringBuilder();
        CarRepository carRepository = new CarRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();
        UserRepository userRepository = new UserRepository();
        EngineerRepository engineerRepository = new EngineerRepository();

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
