package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.repository.CarRepository;


public class MockUUID extends CarRepository {
    @Override
    public void setUUID(Car car) {
        car.setId("spyValues" + count());

    }
}
