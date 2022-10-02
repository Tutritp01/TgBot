package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.repository.CarRepository;

public class CarRepositoryMock extends CarRepository {

    public Car capturedCar;

    @Override
    public Car save(final Car car) {
        captrue(car);
        return null;
    }

    private void captrue(final Car car) {
        final Car captured = new Car();
        captured.setId(car.getId());
        captured.setBrand(car.getBrand());
        captured.setEngine(car.getEngine());
        captured.setGeneration(car.getGeneration());
        captured.setModel(car.getModel());
        captured.setYear(car.getYear());
        captured.setModification(car.getModification());
        capturedCar = captured;
    }
}
