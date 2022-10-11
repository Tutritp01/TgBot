package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.controller.Request;
import com.tutrit.stoservice.repository.CarRepository;

import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import static com.tutrit.stoservice.utils.UtilsInput.stringToMapParser;

public class CarService {
    public static final Logger logger = Logger.getLogger(CarService.class.getName());
    private static CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        CarService.carRepository = carRepository;
    }

    public static void saveCarToRep(Request request) {
        Map<String, String> carInformation = stringToMapParser(request.getInformation());
        Car car = new Car();
        car.setId(UUID.randomUUID().toString());
        for (int i = 0; i < carInformation.size(); i++){
            switch (i){
                case 0 -> car.setBrand(carInformation.get("brand"));
                case 1 -> car.setModel(carInformation.get("model"));
                case 2 -> car.setGeneration(carInformation.get("generation"));
                case 3 -> car.setModification(carInformation.get("modification"));
                case 4 -> car.setEngine(carInformation.get("engine"));
                case 5 -> car.setYear(Integer.parseInt(carInformation.get("year")));
                default -> logger.info("No vehicle data has been saved.");
            }
        }
        carRepository.save(car);
    }
}
