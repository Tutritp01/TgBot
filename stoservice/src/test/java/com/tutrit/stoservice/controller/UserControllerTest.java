package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.service.MessageService;
import com.tutrit.stoservice.service.PromoService;
import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.spy.UserControllerSpy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserControllerTest {

    private UserController userController;
    private UserControllerSpy userControllerSpy;

    @BeforeAll
    public static void load() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    public void setUp() {
        userController = get(UserController.class);
        userControllerSpy = new UserControllerSpy(get(UserService.class),
                get(MessageService.class),
                get(PromoService.class));
    }

    @Test
    void doCommand() {
        var request = new Request("new_user -data -i id1 -n user1 -p 123");
        var response = new Response();

        userControllerSpy.doCommand(request, response);

        var expectedResponse = new Response();
        expectedResponse.setResponse("new user has been saved");

        assertEquals(expectedResponse.getResponse(), response.getResponse());
        assertEquals(1, userControllerSpy.numSaveUserToRep);

    }

    @Test
    void getCommand() {
        Command expectedCommand = Command.fromString("new_user");
        assertEquals(expectedCommand, userController.getCommand());
    }
}
