package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.repository.EngineerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tutrit.stoservice.context.ApplicationContext.*;
import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;

class EngineerControllerTest {
    EngineerController engineerController;
    Command command;
    Request request;
    Response response;

    @BeforeEach
    void SetUp() {
        ApplicationContextLoader.run();
        engineerController = get(EngineerController.class);
        response = new Response();
        fill(get(EngineerRepository.class).engineers, null);
        EngineerRepository.counted = 0;
    }

    @Test
    void doCommandFirst() {
        request = new Request("new engineer -m -d {LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}");
        engineerController.doCommand(request, response);
        assertEquals("Engineer 1 is created", response.getResponse());
    }

    @Test
    void doCommandSecond() {
        request = new Request("new engineer -m -d {LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}");
        engineerController.doCommand(request, response);
        assertEquals("Engineer 1 is created", response.getResponse());
    }

    @Test
    void doCommandFailRequest() {
        request = new Request("new engineer -m -d LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}");
        engineerController.doCommand(request, response);
        assertEquals("Engineer not created", response.getResponse());
    }


    @Test
    void getCommandToString() {
        command = engineerController.getCommand();
        assertEquals("NEW_ENGINEER", command.toString());
    }

    @Test
    void getCommandOrdinal() {
        command = engineerController.getCommand();
        assertEquals(Integer.parseInt("4"), command.ordinal());
    }

    @Test
    void getCommandString() {
        command = engineerController.getCommand();
        assertEquals("new engineer", command.command);
    }
}
