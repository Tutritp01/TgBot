package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.repository.EngineerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {
            "new engineer -m -d {lastName:One firstName:Two function:Three category:Four education:Five experience:6 generalExperience:7}",
            "new engineer -m -d {lastName:One firstName:Two function:Three category:Four education:Five experience:6 generalExperience:7}"
    })
    void doCommandFirstNew(String msgTxt) {
        request = new Request(msgTxt);
        engineerController.doCommand(request, response);
        assertEquals("Engineer 1 is created", response.getResponse());
        getCommandToStringNew();
        getCommandStringNew();
    }

    @Test
    void doCommandFailRequestNew() {
        request = new Request("new engineer -d id=zero&lastName=One&firstName=Two&function=Three&category=Four&education=Five&experience=6&generalExperience=7");
        engineerController.doCommand(request, response);
        request = new Request("get engineer -d id=234532");
        engineerController.doCommand(request, response);
        assertEquals("Error 404: Engineer with 234532 not found", response.getResponse());
//        getCommandToStringNew();
//        getCommandStringNew();
    }

    @Test
    void doCommandGetEngineer () {
        request = new Request("new engineer -m -d {lastName:One firstName:Two function:Three category:Four education:Five experience:6 generalExperience:7}");
        engineerController.doCommand(request, response);
        engineerController.doCommand(request, response);
        request = new Request("get engineer -m -d {id:1}");
        engineerController.doCommand(request, response);
        assertEquals("Engineer with ID: 1 found", response.getResponse());
        request = new Request("get engineer -m -d {id:2}");
        engineerController.doCommand(request, response);
        assertEquals("Engineer with ID: 2 found", response.getResponse());
        getCommandToStringGet();
        getCommandStringGet();
    }

    @Test
    void doCommandGetEngineerNoId() {
        request = new Request("new engineer -m -d {lastName:One firstName:Two function:Three category:Four education:Five experience:6 generalExperience:7}");
        engineerController.doCommand(request, response);
        engineerController.doCommand(request, response);
        request = new Request("get engineer -m -d {id:}");
        engineerController.doCommand(request, response);
        assertEquals("Incorrectly entered command, failed to find the ID", response.getResponse());
    }

    @Test
    void doCommandGetEngineerNotFound() {
        request = new Request("new engineer -m -d {lastName:One firstName:Two function:Three category:Four education:Five experience:6 generalExperience:7}");
        engineerController.doCommand(request, response);
        engineerController.doCommand(request, response);
        request = new Request("get engineer -m -d {id:1}");
        engineerController.doCommand(request, response);
        assertEquals("Engineer with ID: 1 found", response.getResponse());
        request = new Request("get engineer -m -d {id:3}");
        engineerController.doCommand(request, response);
        assertEquals("Error 404: Engineer with 3 not found", response.getResponse());

    }

    void getCommandToStringNew() {
        command = engineerController.getCommand();
        assertEquals("NEW_ENGINEER", command.toString());
    }

    void getCommandStringNew() {
        command = engineerController.getCommand();
        assertEquals("new engineer", command.commands);
    }

    void getCommandToStringGet() {
        command = engineerController.getCommand();
        assertEquals("GET_ENGINEER", command.toString());
    }

    void getCommandStringGet() {
        command = engineerController.getCommand();
        assertEquals("get engineer", command.commands);
    }
}
