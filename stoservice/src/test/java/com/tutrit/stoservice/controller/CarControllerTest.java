package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.service.CarService;
import com.tutrit.stoservice.spy.CarControllerSpy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.tutrit.stoservice.context.ApplicationContext.get;
import static org.junit.jupiter.api.Assertions.*;

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
        var request = new Request("save car -d brand=tesla&model=X&generation=I&modification=suv&engine=diesel&year=2008");
        var response = new Response();

        carControllerSpy.doCommand(request, response);

        var expectedResponse = new Response();
        expectedResponse.setResponse("new car has been saved");

        assertEquals(expectedResponse.getResponse(), response.getResponse());
        assertEquals(1, carControllerSpy.numSaveCarToRep);

    }

    @Test
    void getCommand() {
        Command expectedCommand = Command.fromString("save car");
        assertEquals(expectedCommand, carController.getCommand());
    }
}