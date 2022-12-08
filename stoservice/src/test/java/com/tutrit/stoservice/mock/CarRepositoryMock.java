package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.repository.CarRepository;

public class CarRepositoryMock extends CarRepository {

    public Car capturedCar;


    @Override
    public Car save(Car car) {
        return super.save(car);
    }

    @Override
    public void saveAll(Iterable<Car> cars) {
    }

    @Override
    public Iterable<Car> findAll() {
        return null;
    }

    @Override
    public boolean delete(Car car) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return super.deleteById(id);
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public boolean isContains(String id) {
        return super.isContains(id);
    }

    @Override
    public void setUUID(Car car) {
        MockUUID mockUUID = new MockUUID();
        mockUUID.setUUID(car);
    }
}
