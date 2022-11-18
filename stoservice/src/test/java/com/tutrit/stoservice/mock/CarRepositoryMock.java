package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.repository.CarRepository;

public class CarRepositoryMock extends CarRepository {

    public Car capturedCar;

    @Override
    public Car save(Car car) {
        return new Car("id", "owner", "vin", "plateNumber", "brand", "model", "generation", "modification", "engine", 2008);
    }

    @Override
    public void saveAll(Iterable<Car> cars) {
    }

    @Override
    public Car find(Car car) {
        return null;
    }

    @Override
    public Iterable<Car> findAll() {
        return null;
    }

    @Override
    public Car findById(String id) {
        return null;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean delete(Car car) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public boolean isContains(String id) {
        return false;
    }
}
