package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.repository.*;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

public class RepositoryCarController {

    private CarRepository repository;

    public RepositoryCarController(CarRepository repository) {
        this.repository = repository;
    }

    public void doCommand(Request request, Response response) {
        this.saveCarToRep(request);
        response.setResponse("car saved");
    }

    private void saveCarToRep(Request request) {
        List<String> carInformation = request.getInformation();
        Car car = new Car();
        car.setId(UUID.randomUUID().toString());
        for (int i = 0; i < carInformation.size(); i++){
            switch (i){
                case 0 -> car.setBrand(carInformation.get(i));
                case 1 -> car.setModel(carInformation.get(i));
                case 2 -> car.setGeneration(carInformation.get(i));
                case 3 -> car.setModification(carInformation.get(i));
                case 4 -> car.setEngine(carInformation.get(i));
                case 5 -> car.setYear(Integer.parseInt(carInformation.get(i)));
            }
        }
        repository.save(car);
    }
}
