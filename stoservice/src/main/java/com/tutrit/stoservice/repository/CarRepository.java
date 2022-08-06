package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CarRepository {
    public static final Logger logger = Logger.getLogger(CarRepository.class.getName());
    public static List<Car> cars = new ArrayList<>();

    public Car createCar(Car car) {
        if (isContains(car.getId())) {
            return updateCar(car);
        } else {
            cars.add(car);
        }
        return car;
    }

    public Car findCar(Car car) {
        return findCarById(car.getId());
    }

    public Car findCarById(String id) {
        Car car = new Car();
        try {
            if(!isContains(id)) {
                throw new CarNotFoundException("Car not found!");
            }
            for (int i = 0; i < cars.size(); i++) {
                if (id.equals(cars.get(i).getId())) {
                    car = cars.get(i);
                }
            }
        } catch (CarNotFoundException e) {
            logger.severe("Car not found!");
        }
        return car;
    }

    public Car updateCar(Car car) {
        cars.set((cars.indexOf(findCar(car))), car);
        return car;
    }

    public boolean deleteCar(Car car) {
        return cars.remove(findCarById(car.getId()));
    }

    public boolean deleteCar(String id) {
        return cars.remove(findCarById(id));
    }

    public int count() {
        return cars.size();
    }

    public boolean isContains(String id) {
        Car car = null;
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                car = cars.get(i);
            }
        }
        return car != null;
    }

    private static class CarNotFoundException extends Exception {
        public CarNotFoundException(String s) {
        }
    }
}
