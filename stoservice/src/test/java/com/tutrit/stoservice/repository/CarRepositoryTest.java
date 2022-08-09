package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
    }

    @Test
    void createCar() {
        Car car1 = new Car("id1", "brand1", "model1", "1g", "mod1", "engine1", "2001");
        Car car2 = new Car("id2", "brand2", "model2", "2g", "mod2", "engine2", "2002");
        Car car3 = new Car("id3", "brand3", "model3", "3g", "mod3", "engine3", "2003");
        CarRepository.cars.add(car1);
        CarRepository.cars.add(car2);
        CarRepository.cars.add(car3);
        int expected = carRepository.count() + 2;
        carRepository.createCar(new Car("id4", "brand4", "model4", "4g", "mod4", "engine4", "2004"));
        carRepository.createCar(new Car("id5", "brand5", "model5", "5g", "mod5", "engine5", "2005"));

        assertEquals(expected, carRepository.count());

        int expected2 = carRepository.count();
        carRepository.createCar(new Car("id3", "brand4", "model5", "6g", "mod7", "engine8", "2009"));
        assertEquals(expected2, carRepository.count());
    }

    @Test
    void findCar() {
        Car car6 = new Car("id6", "brand6", "model6", "6g", "mod6", "engine6", "2006");
        Car car7 = new Car("id7", "brand7", "model7", "7g", "mod7", "engine7", "2007");
        Car car8 = new Car("id8", "brand8", "model8", "8g", "mod8", "engine8", "2008");
        Car car9 = new Car("id9", "brand9", "model9", "9g", "mod9", "engine9", "2009");
        carRepository.createCar(car6);
        carRepository.createCar(car7);
        carRepository.createCar(car8);
        carRepository.createCar(car9);

        assertEquals(car9, carRepository.findCar(car9));
    }

    @Test
    void findCarById() {
        Car car10 = new Car("id10", "brand10", "model10", "10g", "mod10", "engine10", "2010");
                Car car11 = new Car("id11", "brand11", "model11", "11g", "mod11", "engine11", "2011");
        Car car12 = new Car("id11", "brand12", "model12", "12g", "mod12", "engine12", "20012");
        Car car13 = new Car("id13", "brand13", "model13", "13g", "mod13", "engine13", "2013");
        carRepository.createCar(car10);
        carRepository.createCar(car11);
        carRepository.createCar(car12);
        carRepository.createCar(car13);

        assertEquals(car13, carRepository.findCarById("id13"));

    }

    @Test
    void updateCar() {
        Car car14 = new Car("id14", "brand14", "model14", "14g", "mod14", "engine14", "2014");
        Car car15 = new Car("id15", "brand15", "model15", "15g", "mod15", "engine15", "2015");
        Car car16 = new Car("id16", "brand16", "model16", "16g", "mod16", "engine16", "2016");
        Car car17 = new Car("id17", "brand17", "model17", "17g", "mod17", "engine17", "2017");
        Car car18 = new Car("id17", "brand18", "model18", "18g", "mod18", "engine18", "2018");
        carRepository.createCar(car14);
        carRepository.createCar(car15);
        carRepository.createCar(car16);
        carRepository.createCar(car17);
        int actIndex = carRepository.cars.indexOf(car17);
        carRepository.updateCar(car18);
        assertEquals(carRepository.cars.indexOf(car18), actIndex);
    }

    @Test
    void deleteCar() {
        Car car19 = new Car("id19", "brand19", "model19", "19g", "mod19", "engine19", "2019");
                Car car20 = new Car("id20", "brand20", "model20", "20g", "mod20", "engine20", "2020");
        carRepository.createCar(car19);
        carRepository.createCar(car20);
        int expected = carRepository.count() - 1;
        carRepository.deleteCar(car20);

        assertEquals(expected, carRepository.count());
    }

    @Test
    void testDeleteCar() {
        Car car21 = new Car("id21", "brand21", "model21", "21g", "mod21", "engine21", "2021");
        Car car22 = new Car("id22", "brand22", "model22", "22g", "mod22", "engine22", "2022");
        carRepository.createCar(car21);
        carRepository.createCar(car22);
        int expected = carRepository.count() - 1;
        carRepository.deleteCar("id21");

        assertEquals(expected, carRepository.count());
    }

    @Test
    void count() {
        Car car23 = new Car("id23", "brand23", "model23", "23g", "mod23", "engine23", "2023");
        Car car24 = new Car("id24", "brand24", "model24", "24g", "mod24", "engine24", "2024");
        Car car25 = new Car("id25", "brand25", "model25", "25g", "mod25", "engine25", "2025");
        carRepository.createCar(car23);
        carRepository.createCar(car24);
        carRepository.createCar(car25);
        int size = CarRepository.cars.size();
        carRepository.deleteCar(car23);
        carRepository.deleteCar(car24);

        assertEquals(size - 2, CarRepository.cars.size());
    }

    @Test
    void isContains() {
        Car car26 = new Car("id26", "brand26", "model26", "26g", "mod26", "engine26", "2026");
        Car car27 = new Car("id27", "brand27", "model27", "27g", "mod27", "engine27", "2027");
        Car car28 = new Car("id28", "brand28", "model28", "28g", "mod28", "engine28", "2028");
        carRepository.createCar(car26);
        carRepository.createCar(car27);

        assertTrue(carRepository.isContains(car27.getId()));
        assertFalse(carRepository.isContains(car28.getId()));
    }
}
