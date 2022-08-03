package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    public static List<Car> cars = new ArrayList<>();

    public boolean createCar(Car car) {
        return cars.add(car);
    }

    public Car findCar(Car car) {
        return cars.get(cars.indexOf(car));
    }

    public Car findCarById(String id) {
        Car car = new Car();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                car = cars.get(i);
            }
        }
        return car;
    }

    public Car updateCar(Car car) {
        cars.add(car);
        return car;
    }

    public boolean deleteCar(Car car) {
        return cars.remove(car);
    }

    public boolean deleteCar(String id) {
        Car car = new Car();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                car = cars.get(i);
            }
        }
        return cars.remove(car);
    }

    public int count() {
        return cars.size();
    }
}
