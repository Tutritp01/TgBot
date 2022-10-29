package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.mock.CarRepositoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarServiceTest {

    private CarService carService;

    @BeforeAll
    public static void load() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    void setUp() {
        carService = ApplicationContext.get(CarService.class);
        carService.setCarRepository(new CarRepositoryMock());
    }

    @Test
    void saveCar() {
        Car car = carService.saveCar(new Car("id", "brand", "model", "generation", "modification", "engine", 2008));
        Assertions.assertEquals(makeCar(), car);
    }

    private Car makeCar() {
        return new Car("id", "brand", "model", "generation", "modification", "engine", 2008);
    }
}
