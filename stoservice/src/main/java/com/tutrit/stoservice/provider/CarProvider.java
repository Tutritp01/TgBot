package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Car;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

import java.util.ArrayList;
import java.util.List;

public class CarProvider implements DemoDataProvider {
    public List<Car> getCar() {
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Car init = getInstance();
            init.setId("id" + i);
            cars.add(init);
        }
        return cars;
    }

    @Override
    public List<Object> getInstances() {
        return new ArrayList<>(getCar());
    }

    public static Car getInstance() {
        return new Car("id", "brand", "model", "generation", "modification", "engine", 2000);
    }
}
