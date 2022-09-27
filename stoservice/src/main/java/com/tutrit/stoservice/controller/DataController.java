package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.repository.*;

public class DataController implements CommandController {

    public void doCommand(Request request, Response response) {
        request.getCommand();
        response.setResponse(String.format(this.loadedDataAsString()));
    }

    private String loadedDataAsString() {
        StringBuilder rs = new StringBuilder();
        CarRepository carRepository = new CarRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();
        UserRepository userRepository = new UserRepository();
        EngineerRepository engineerRepository = new EngineerRepository();

        carRepository.findAll().forEach(car -> rs.append(car.toString()));
        customerRepository.findAll().forEach(customer -> rs.append(customer.toString()));
        orderRepository.findAll().forEach(order -> rs.append(order.toString()));
        userRepository.findAll().forEach(user -> rs.append(user.toString()));
        engineerRepository.findAll().forEach(engineer -> rs.append(engineer.toString()));

        return rs.toString();
    }
}
