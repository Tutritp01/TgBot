package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class CarRepository implements Repository<Car, String> {
    public static final Logger logger = Logger.getLogger(CarRepository.class.getName());
    private static final List<Car> cars = new ArrayList<>();

    @Override
    public Car save(Car car) {
        if (isContains(car.getId())) {
            return update(car);
        } else {
            cars.add(car);
        }
        return car;
    }

    @Override
    public void saveAll(Iterable<Car> cars) {
        CarRepository.cars.addAll((Collection<? extends Car>) cars);
    }

    @Override
    public Car find(Car car) {
        return findById(car.getId());
    }

    @Override
    public Iterable<Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(String id) {
        Car car = null;
        try {
            if (!isContains(id)) {
                throw new CarNotFoundException("Car not found!");
            }
            for (Car value : cars) {
                if (id.equals(value.getId())) {
                    car = value;
                }
            }
        } catch (CarNotFoundException e) {
            logger.severe("Car not found!");
        }
        return car;
    }

    @Override
    public Car update(Car car) {
        cars.set((cars.indexOf(find(car))), car);
        return car;
    }

    @Override
    public boolean delete(Car car) {
        return cars.remove(findById(car.getId()));
    }

    @Override
    public boolean deleteById(String id) {
        return cars.remove(findById(id));
    }

    public int count() {
        return cars.size();
    }

    public boolean isContains(String id) {
        Car car = null;
        for (Car value : cars) {
            if (id.equals(value.getId())) {
                car = value;
            }
        }
        return car != null;
    }

    private static class CarNotFoundException extends Exception {
        public CarNotFoundException(String s) {
        }
    }
}
