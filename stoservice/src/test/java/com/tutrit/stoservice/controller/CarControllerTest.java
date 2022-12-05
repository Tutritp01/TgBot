package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.service.CarService;
import com.tutrit.stoservice.spy.CarControllerSpy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarControllerTest {
    private CarController carController;
    private CarControllerSpy carControllerSpy;

    @BeforeAll
    public static void load() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    public void setUp() {
        carController = get(CarController.class);
        carControllerSpy = new CarControllerSpy(get(CarService.class));
    }

    @Test
    void doCommand() {
        var request = new Request("save car -d owner=Mask&vin=1234321&plateNumber=0000AA1&brand=tesla&model=X&generation=I&modification=suv&engine=diesel&year=2008");
        var response = new Response();

        carControllerSpy.doCommand(request, response);

        var expectedResponse = new Response();
        expectedResponse.setResponse("new car has been saved");

        assertEquals(expectedResponse.getResponse(), response.getResponse());
        assertEquals(1, carControllerSpy.numSaveCarToRep);

    }

    @Test
    void getCommand() {
        carController.doCommand(new Request("save car"), new Response());
        Command expectedCommand = Command.fromString("save car");
        assertEquals(expectedCommand, carController.getCommand());
    }

    @Test
    void integrationCarControllerTest() {
        Response response = new Response();
        Request request = new Request("save car -d id=zero&owner=Vlad&vin=vw1989zzz1234321&plateNumber=0000AA1&brand=volkswagen&model=golf&generation=II&modification=hatchback&engine=diesel&year=1989");
        carController.doCommand(request, response);
        assertEquals("new car has been saved", response.getResponse());
        request = new Request("get car -d id=234532");
        carController.doCommand(request, response);
        assertEquals("Error 404: car with 234532 not found", response.getResponse());
    }
}

