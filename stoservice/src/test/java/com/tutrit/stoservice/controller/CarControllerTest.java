package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.repository.CarRepository;
import com.tutrit.stoservice.service.CarRepositoryMock;
import com.tutrit.stoservice.service.CarService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarControllerTest {

    @Test
    void doCommand() {
        CarRepositoryMock carRepositoryMock = new CarRepositoryMock();
        CarControllerSpy carController = new CarControllerSpy(new CarService(carRepositoryMock));
        Request request = new Request("save car -d brand=tesla&model=X&generation=I&modification=suv&engine=diesel&year=2008");
        Response response = new Response();

        carController.doCommand(request, response);

        Response expectedResponse = new Response();
        expectedResponse.setResponse("car saved");
        assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(expectedResponse);

        assertEquals(1, carController.numSaveCarToRep);
    }
}