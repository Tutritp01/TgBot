package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.repository.CarRepository;



public class CarService {

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
