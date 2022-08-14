package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Car;

import java.util.ArrayList;
import java.util.List;

public class CarProvider {
    public List<Car> getCar() {
        Car car = getInstance();
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            car.setId(String.valueOf(i));
            cars.add(new Car());
        }
        return cars;
    }
    public  static Car getInstance(){

        return new Car("id", "brand", "model", "generation", "modification", "engine", "year");
    }
}
