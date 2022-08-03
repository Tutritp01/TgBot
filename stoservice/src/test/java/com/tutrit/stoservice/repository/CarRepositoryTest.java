package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRepositoryTest {

    CarRepository carRepository;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        car1 = new Car("id1", "brand1", "model1", "1g", "mod1", "engine1", 2001);
        car2 = new Car("id2", "brand2", "model2", "2g", "mod2", "engine2", 2002);
        car3 = new Car("id3", "brand3", "model3", "3g", "mod3", "engine3", 2003);
        CarRepository.cars.add(car1);
        CarRepository.cars.add(car2);
        CarRepository.cars.add(car3);
    }

    @Test
    void createCar() {
        int expected = carRepository.count() + 2;
        carRepository.createCar(new Car("id4", "brand4", "model4", "4g", "mod4", "engine4", 2004));
        carRepository.createCar(new Car("id5", "brand5", "model5", "5g", "mod5", "engine5", 2005));

        assertEquals(expected, carRepository.count());
    }

    @Test
    void findCar() {
        Car car6 = new Car("id6", "brand6", "model6", "6g", "mod6", "engine6", 2006);
        carRepository.createCar(car6);

        assertEquals(car6, carRepository.findCar(car6));
    }

    @Test
    void findCarById() {
        Car car7 = new Car("id7", "brand7", "model7", "7g", "mod7", "engine7", 2007);
        carRepository.createCar(car7);

        assertEquals(car7, carRepository.findCarById("id7"));

    }

    @Test
    void updateCar() {
        Car car8 = new Car("id8", "brand8", "model8", "8g", "mod8", "engine8", 2008);
        int expected = carRepository.count() + 1;

        assertEquals(car8, carRepository.updateCar(car8));
        assertEquals(expected, carRepository.count());
    }

    @Test
    void deleteCar() {
        int expected = carRepository.count() - 1;
        carRepository.deleteCar(car1);

        assertEquals(expected, carRepository.count());
    }

    @Test
    void testDeleteCar() {
        int expected = carRepository.count() - 1;
        carRepository.deleteCar("id1");

        assertEquals(expected, carRepository.count());
    }

    @Test
    void count() {
        carRepository.createCar(car1);
        carRepository.createCar(car2);
        carRepository.createCar(car3);
        int size = CarRepository.cars.size();
        carRepository.deleteCar(car1);
        carRepository.deleteCar(car2);

        assertEquals(size - 2, CarRepository.cars.size());
    }
}
