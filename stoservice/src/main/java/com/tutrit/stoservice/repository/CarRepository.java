package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Car;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class CarRepository implements Repository<Car, String> {
    public static final Logger logger = Logger.getLogger(CarRepository.class.getName());
    public static List<Car> cars = new ArrayList<>();

    @Override
    public Car save(final Car car) {
        if (isContains(car.getId())) {
            return update(car);
        } else {
            cars.add(car);
        }
        return car;
    }

    @Override
    public void saveAll(Iterable<Car> cars) {

    }

    @Override
    public void saveAll(Car[] cars) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("We don't wont work with arrays");
    }

    @Override
    public Car find(final Car car) {
        return findById(car.getId());
    }

    @Override
    public List<Car> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Car findById(final String id) {
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

    @Override
    public Car update(final Car car) {
        cars.set((cars.indexOf(find(car))), car);
        return car;
    }

    @Override
    public boolean delete(final Car car) {
        return cars.remove(findById(car.getId()));
    }

    @Override
    public boolean deleteById(final String id) {
        return cars.remove(findById(id));
    }

    @Override
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
