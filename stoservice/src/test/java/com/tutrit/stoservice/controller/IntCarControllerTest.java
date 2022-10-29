package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IntCarControllerTest {
    CarController carController;

    @BeforeAll
    public static void load() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    public void setUp() {
        carController = ApplicationContext.get(CarController.class);
    }

    @Test
    void doCommand() {
        var request = new Request("save car -d brand=tesla&model=X&generation=I&modification=suv&engine=diesel&year=2008");
        var response = new Response();

        carController.doCommand(request, response);

        var expectedResponse = new Response();
        expectedResponse.setResponse("new car has been saved");
        assertEquals(expectedResponse.getResponse(), response.getResponse());
    }
}
