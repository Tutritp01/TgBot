package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreateEngineerServiceMock {

    CreateEngineerService createEngineerService;
    ByteArrayOutputStream output;

    CreateEngineerServiceMock() {
        createEngineerService = new CreateEngineerService(new EngineerRepoMockTest());
        output = new ByteArrayOutputStream();
    }


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void createTest() {
        createEngineerService.create(createEngineer());
        assertEquals("Done!\r\n", output.toString());
    }

    private Engineer createEngineer() {
        return new Engineer("0", "FName", "LName", "Func", "Cat", "Edu", 0, 0);
    }

    @AfterEach
    void cleanUpStreams() {
        System.setOut(null);
    }
}
