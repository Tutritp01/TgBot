package com.tutrit.tgbot.example.repository;

import com.tutrit.tgbot.example.bean.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRepositoryTest {

    private static CarRepository carRepository;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void init() {
        carRepository = new CarRepository();
        car1 = new Car("1", "1", "1", "1", "1", 2, "2");
        car2 = new Car("2", "1", "1", "1", "1", 2, "2");
        car3 = new Car("3", "1", "1", "1", "1", 2, "2");
    }

    @Test
    void createCar() {
        carRepository.createCar(car1);

        assertEquals(1, carRepository.count());
    }

    @Test
    void readCar() {
        carRepository.createCar(car1);
        carRepository.createCar(car2);
        carRepository.createCar(car3);

        assertEquals(car2.toString(), carRepository.readCar(car2));
    }

    @Test
    void updateCar() {
        carRepository.createCar(car1);
        carRepository.createCar(car2);

        carRepository.updateCar(car1, car3);
        assertEquals(car3.toString(), carRepository.readCar(car3));

    }

    @Test
    void deleteCar() {
        carRepository.createCar(car1);
        carRepository.createCar(car2);
        carRepository.createCar(car3);

        carRepository.deleteCar(car1);

        assertEquals(2, carRepository.count());
    }
}
