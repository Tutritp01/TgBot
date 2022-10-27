package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.controller.Request;
import com.tutrit.stoservice.repository.CarRepository;

import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;



public class CarService {
//    public static final Logger logger = Logger.getLogger(CarService.class.getName());
    private CarRepository carRepository;

    public CarService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car saveCar(Car car) {
       return carRepository.save(car);
    }
    public void setCarRepository(CarRepository carRepository){
        this.carRepository = carRepository;
    }
}
