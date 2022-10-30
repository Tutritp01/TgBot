package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.repository.EngineerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EngineerControllerTest {
    EngineerController engineerController;
    Command command;
    Request request;
    Response response;

    @BeforeEach
    void SetUp() {
        ApplicationContextLoader.run();
        engineerController = ApplicationContext.get(EngineerController.class);
        response = new Response();
        Arrays.fill(ApplicationContext.get(EngineerRepository.class).engineers, null);
        EngineerRepository.counted = 0;
    }

    @Test
    void doCommandFirst() {
        request = new Request("new engineer -m -d {LastName:One FirstName:Two Function:Three Category:Four Education:Five Experience:6 GeneralExperience:7}");
        engineerController.doCommand(request, response);
        assertEquals("Engineer 1 is created", response.getResponse());
    }

    @Test
    void doCommandSecond() {
        request = new Request("new engineer -m -d {LastName:One FirstName:Two Function:Three Category:Four Education:Five Experience:6 GeneralExperience:7}");
        engineerController.doCommand(request, response);
        assertEquals("Engineer 1 is created", response.getResponse());
    }

    @Test
    void doCommandFailRequest() {
        request = new Request("new engineer -m -d LastName:One FirstName:Two Function:Three Category:Four Education:Five Experience:6 GeneralExperience:7}");
        engineerController.doCommand(request, response);
        assertEquals("Engineer not created", response.getResponse());
    }

    @Test
    void getCommandToString() {
        command = engineerController.getCommand();
        assertEquals("NEW_ENGINEER", command.toString());
    }

    @Test
    void getCommandString() {
        command = engineerController.getCommand();
        assertEquals("new engineer", command.command);
    }
}