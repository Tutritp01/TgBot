package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.repository.CarRepository;
import com.tutrit.stoservice.repository.CustomerRepository;
import com.tutrit.stoservice.repository.EngineerRepository;
import com.tutrit.stoservice.repository.OrderRepository;
import com.tutrit.stoservice.repository.UserRepository;
import com.tutrit.stoservice.usecase.RegisterUserUseCase;

public class UserController implements CommandController {
    private final Command command = Command.REGISTER_NEW_USER;
    RegisterUserUseCase registerUser;

    public UserController(final RegisterUserUseCase registerUser) {
        this.registerUser = registerUser;
    }

    public void doCommand(Request request, Response response) {
        String command = request.getCommand();
        response.setResponse(String.format(this.loadedDataAsString()));
    }

    private String loadedDataAsString() {
        StringBuilder rs = new StringBuilder();
        CarRepository.cars.forEach(car -> rs.append(car.toString()));
        CustomerRepository.customers.forEach(customer -> rs.append(customer.toString()));
        OrderRepository.orders.forEach((orderK, orderV) -> rs.append(String.format("Key: %s. Value: %s", orderK, orderV)));
        UserRepository.userMap.forEach((userK, userV) -> rs.append(String.format("Key: %s. Value: %s", userK, userV)));
        EngineerRepository engineerRepository = new EngineerRepository();
//        for (Engineer engineer : engineerRepository.findAll()) {
//            if(engineer != null) {
//                rs.append(engineer.toString());
//            }
//        }
        return rs.toString();
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
