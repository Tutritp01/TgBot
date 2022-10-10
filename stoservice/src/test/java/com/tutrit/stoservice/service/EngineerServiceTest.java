package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineerServiceTest {
    EngineerService engineerService;

    EngineerServiceTest() {
        engineerService = new EngineerService(new EngineerRepository());
    }

    @Test
    void createTest() {
        engineerService.save(createEngineer());
        engineerService.save(createEngineer());
        engineerService.save(createEngineer());
        engineerService.save(createEngineer());
        assertEquals(EngineerRepository.engineers.length, 8);
    }

    private Engineer createEngineer() {
        return new Engineer("0", "FName", "LName", "Func", "Cat", "Edu", 0, 0);
    }
}
