package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositoryCarControllerTest {


    @Test
    void doCommand() {
        CarRepositoryMock carRepositoryMock = new CarRepositoryMock();
        RepositoryCarControllerSpy repositoryCarController = new RepositoryCarControllerSpy(carRepositoryMock);
        Request request = new Request("saveCar brand model generation modification engine 2005");
        Response response = new Response();

        repositoryCarController.doCommand(request, response);

        Response expectedResponse = new Response();
        expectedResponse.setResponse("car saved");
        Assertions.assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(expectedResponse);

        Request expected = new Request("saveCar brand model generation modification engine 2005");

        assertEquals(1, repositoryCarController.numSaveCarToRepCalled);
        Assertions.assertThat(repositoryCarController.capturedRequest)
                .usingRecursiveComparison()
                .isEqualTo(expected);

        Car car = new Car();
        car.setModification("modification");
        car.setId("90980970978");
        car.setYear(2005);
        car.setModel("model");
        car.setGeneration("generation");
        car.setBrand("brand");
        car.setEngine("engine");

        Assertions.assertThat(carRepositoryMock.capturedCar)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(car);
    }
}