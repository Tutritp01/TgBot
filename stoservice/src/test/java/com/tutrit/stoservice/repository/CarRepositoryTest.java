package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.mock.CarRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
    }

    @Test
    void saveCar() {
        Car car1 = new Car("id1", "owner", "vin", "plateNumber", "brand1", "model1", "1g", "mod1", "engine1", 2001);
        Car car2 = new Car("id2", "owner", "vin", "plateNumber", "brand2", "model2", "2g", "mod2", "engine2", 2002);
        Car car3 = new Car("id3", "owner", "vin", "plateNumber", "brand3", "model3", "3g", "mod3", "engine3", 2003);
        int expected = carRepository.count() + 5;
        carRepository.save(new Car("id4", "owner", "vin", "plateNumber", "brand4", "model4", "4g", "mod4", "engine4", 2004));
        carRepository.save(new Car("id5", "owner", "vin", "plateNumber", "brand5", "model5", "5g", "mod5", "engine5", 2005));
        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

        assertEquals(expected, carRepository.count());

        carRepository.save(new Car("id3", "owner", "vin", "plateNumber", "brand4", "model5", "6g", "mod7", "engine8", 2009));
        int expected2 = carRepository.count();
        assertEquals(expected2, carRepository.count());
    }

    @Test
    void saveAll() {
        Car car29 = new Car("id29", "owner", "vin", "plateNumber", "brand29", "model29", "29g", "mod29", "engine29", 2029);
        Car car30 = new Car("id30", "owner", "vin", "plateNumber", "brand30", "model30", "30g", "mod30", "engine30", 2030);
        Car car31 = new Car("id31", "owner", "vin", "plateNumber", "brand31", "model31", "31g", "mod31", "engine31", 2031);
        carRepository.save(car29);
        carRepository.save(car30);
        carRepository.save(car31);
        int expected = carRepository.count() + 3;

        List<Car> listCars = List.of(car29, car30, car31);
        carRepository.saveAll(listCars);

        assertEquals(expected, carRepository.count());

    }

    @Test
    void findCar() {
        Car car6 = new Car("id6", "owner", "vin", "plateNumber", "brand6", "model6", "6g", "mod6", "engine6", 2006);
        Car car7 = new Car("id7", "owner", "vin", "plateNumber", "brand7", "model7", "7g", "mod7", "engine7", 2007);
        Car car8 = new Car("id8", "owner", "vin", "plateNumber", "brand8", "model8", "8g", "mod8", "engine8", 2008);
        Car car9 = new Car("id9", "owner", "vin", "plateNumber", "brand9", "model9", "9g", "mod9", "engine9", 2009);
        carRepository.save(car6);
        carRepository.save(car7);
        carRepository.save(car8);
        carRepository.save(car9);

        assertEquals(car9, carRepository.find(car9));
    }

    @Test
    void findByIdCar() {
        carRepository = new CarRepositoryMock();
        Car car10 = new Car("id10", "owner", "vin", "plateNumber", "brand10", "model10", "10g", "mod10", "engine10", 2010);
        Car car11 = new Car("id11", "owner", "vin", "plateNumber", "brand11", "model11", "11g", "mod11", "engine11", 2011);
        Car car12 = new Car("id11", "owner", "vin", "plateNumber", "brand12", "model12", "12g", "mod12", "engine12", 2012);
        Car car13 = new Car("id13", "owner", "vin", "plateNumber", "brand13", "model13", "13g", "mod13", "engine13", 2013);
        carRepository.save(car10);
        carRepository.save(car11);
        carRepository.save(car12);
        carRepository.save(car13);

        assertEquals(carRepository.find(car11), carRepository.findById("spyValues2"));
    }

    @Test
    void findAll() throws NoSuchFieldException, IllegalAccessException {
        Class<CarRepository> carRepositoryClass = CarRepository.class;
        Field cars = carRepositoryClass.getDeclaredField("cars");
        cars.setAccessible(true);
        List<Car> myCars = (List<Car>) cars.get(carRepositoryClass);

        assertEquals(myCars, carRepository.findAll());
    }

    @Test
    void updateCar() {
        carRepository = new CarRepositoryMock();
        Car car14 = new Car("id14", "owner", "vin", "plateNumber", "brand14", "model14", "14g", "mod14", "engine14", 2014);
        Car car15 = new Car("id15", "owner", "vin", "plateNumber", "brand15", "model15", "15g", "mod15", "engine15", 2015);
        Car car16 = new Car("id16", "owner", "vin", "plateNumber", "brand16", "model16", "16g", "mod16", "engine16", 2016);
        Car car17 = new Car("id17", "owner", "vin", "plateNumber", "brand17", "model17", "17g", "mod17", "engine17", 2017);
        Car car18 = new Car("spyValues2", "owner", "vin", "plateNumber", "brand18", "model18", "18g", "mod18", "engine18", 2018);
        carRepository.save(car14);
        carRepository.save(car15);
        carRepository.save(car16);
        carRepository.save(car17);
        carRepository.update(car18);

        assertEquals(car18, carRepository.findById("spyValues2"));
    }

    @Test
    void deleteCar() {
        Car car19 = new Car("id19", "owner", "vin", "plateNumber", "brand19", "model19", "19g", "mod19", "engine19", 2019);
        Car car20 = new Car("id20", "owner", "vin", "plateNumber", "brand20", "model20", "20g", "mod20", "engine20", 2020);
        carRepository.save(car19);
        carRepository.save(car20);
        int expected = carRepository.count() - 1;
        carRepository.delete(car20);

        assertEquals(expected, carRepository.count());
    }

    @Test
    void deleteByIdCar() {
        carRepository = new CarRepositoryMock();
        Car car21 = new Car("id21", "owner", "vin", "plateNumber", "brand21", "model21", "21g", "mod21", "engine21", 2021);
        Car car22 = new Car("id22", "owner", "vin", "plateNumber", "brand22", "model22", "22g", "mod22", "engine22", 2022);
        carRepository.save(car21);
        carRepository.save(car22);
        int expected = carRepository.count() - 1;
        carRepository.deleteById("spyValues2");
        assertEquals(expected, carRepository.count());
    }

    @Test
    void count() {
        int counter = 0;
        for (Car car : carRepository.findAll()) {
            counter++;
        }

        assertEquals(carRepository.count(), counter);
    }

    @Test
    void isContains() {
        Car car26 = new Car("id26", "owner", "vin", "plateNumber", "brand26", "model26", "26g", "mod26", "engine26", 2026);
        Car car27 = new Car("id27", "owner", "vin", "plateNumber", "brand27", "model27", "27g", "mod27", "engine27", 2027);
        Car car28 = new Car("id28", "owner", "vin", "plateNumber", "brand28", "model28", "28g", "mod28", "engine28", 2028);
        carRepository.save(car26);
        carRepository.save(car27);

        assertTrue(carRepository.isContains(car27.getId()));
        assertFalse(carRepository.isContains(car28.getId()));
    }
}
