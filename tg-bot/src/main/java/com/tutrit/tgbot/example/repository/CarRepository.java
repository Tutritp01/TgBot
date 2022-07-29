package com.tutrit.tgbot.example.repository;

import com.tutrit.tgbot.example.bean.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private static final Logger logger = LoggerFactory.getLogger(CarRepository.class);
    private final List<Car> cars = new ArrayList<>();

    public void createCar(Car car) {
        cars.add(car);
    }

    public String readCar(Car car) {
        String result = null;
        try {
            if (!cars.contains(car)) {
                throw new CarNotFoundException("Car not found!");
            }
            result = cars.get(cars.indexOf(car)).toString();
        } catch (CarNotFoundException e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    public void updateCar(Car car1, Car car2) {
        try {
            if (!cars.contains(car1)) {
                throw new CarNotFoundException("Car not found!");
            }
            cars.set(cars.indexOf(car1), car2);
        } catch (CarNotFoundException e) {
            logger.error(e.getMessage());
        }

    }

    public void deleteCar(Car car) {
        cars.remove(car);
    }

    public int count() {
        return cars.size();
    }


    private static class CarNotFoundException extends Exception {
        public CarNotFoundException(String s) {
        }
    }
}
