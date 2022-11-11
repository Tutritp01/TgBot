package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;
import com.tutrit.stoservice.service.mock.EngineerRepositoryMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineerServiceTest {
    EngineerRepository engineerRepository = new EngineerRepositoryMock();
    EngineerService engineerService = new EngineerService(engineerRepository);
    Engineer engineerExpected = new Engineer(
            "1",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            6,
            7
    );
    Engineer engineer = new Engineer(
            "1",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            6,
            7
    );
    Engineer engineerNoId = new Engineer(
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            6,
            7
    );

    @Test
    void saveTest() {
        engineerService.saveEngineer(engineer);
        assertEquals(engineerExpected, engineerRepository.engineers[0]);
    }

    @Test
    void saveEngineerNoIdTest() {
        engineerService.saveEngineer(engineerNoId);
        assertEquals(engineerExpected, engineerRepository.engineers[0]);
    }
}
