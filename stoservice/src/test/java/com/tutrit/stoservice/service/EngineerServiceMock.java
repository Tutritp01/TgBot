package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EngineerServiceMock {

    EngineerService engineerService;
    ByteArrayOutputStream output;

    EngineerServiceMock() {
        engineerService = new EngineerService(new EngineerRepoMockTest());
        output = new ByteArrayOutputStream();
    }


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void createTest() {
        engineerService.save(createEngineer());
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
