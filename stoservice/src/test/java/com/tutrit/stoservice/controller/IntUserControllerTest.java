package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntUserControllerTest {
    private UserController userController;

    @BeforeAll
    public static void load() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    public void setUp() {
        userController = ApplicationContext.get(UserController.class);
    }

    @Test
    void doCommand() {
        var request = new Request("new_user -data -i id1 -n user1 -p 123");
        var response = new Response();

        userController.doCommand(request, response);

        var expectedResponse = new Response();
        expectedResponse.setResponse("new user has been saved");

        assertEquals(expectedResponse.getResponse(), response.getResponse());
    }
}
