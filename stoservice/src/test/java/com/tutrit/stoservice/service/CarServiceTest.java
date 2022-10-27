package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.controller.CarController;
import com.tutrit.stoservice.controller.Request;
import com.tutrit.stoservice.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.UUID;

import static com.tutrit.stoservice.utils.UtilsInput.stringToMapParser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    CarController carController;
    CarRepositoryMock carRepositoryMock;
    CarService carService;
    Request request;

    @BeforeEach
    void setUp() {

        carRepositoryMock = new CarRepositoryMock();
        request = new Request("save car -d brand=tesla&model=X&generation=I&modification=suv&engine=diesel&year=2008");
        carService = new CarService(carRepositoryMock);
        carController = new CarController(carService);
        Car carExpected = new Car("2243434","tesla", "X", "I", "suv", "diesel", 2008);
    }


    @Test
    void saveCarToRep() {
                Map<String, String> carInformation = stringToMapParser(request.getInformation());
        Car carExpected = new Car("2243434","tesla", "X", "I", "suv", "diesel", 2008);
        CarService.saveCarToRep(request);
        assertThat(carRepositoryMock.capturedCar)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(carExpected);
    }
}