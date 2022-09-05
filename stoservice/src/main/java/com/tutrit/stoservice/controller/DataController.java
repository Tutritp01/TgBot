package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.*;

public class DataController {

    public void doCommand(Request request, Response response) {
        request.getCommand();
        response.setResponse(String.format(this.loadedDataAsString()));
    }

    private String loadedDataAsString() {
        StringBuilder rs = new StringBuilder();
        CarRepository.cars.forEach(car -> rs.append(car.toString()));
        CustomerRepository.customers.forEach(customer -> rs.append(customer.toString()));
        OrderRepository.orders.forEach((orderK, orderV) -> rs.append(String.format("Key: %s. Value: %s", orderK, orderV)));
        UserRepository.userMap.forEach((userK, userV) -> rs.append(String.format("Key: %s. Value: %s", userK, userV)));
        EngineerRepository engineerRepository = new EngineerRepository();
        for (Engineer engineer : engineerRepository.findAll()) {
            if(engineer != null) {
                rs.append(engineer.toString());
            }
        }
        return rs.toString();
    }
}
