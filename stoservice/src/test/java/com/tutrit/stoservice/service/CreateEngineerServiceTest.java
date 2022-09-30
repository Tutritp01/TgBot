package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateEngineerServiceTest {
    CreateEngineerService createEngineerService;

    CreateEngineerServiceTest() {
        createEngineerService = new CreateEngineerService(new EngineerRepository());
    }

    @Test
    void createTest() {
        createEngineerService.create(createEngineer());
        createEngineerService.create(createEngineer());
        createEngineerService.create(createEngineer());
        createEngineerService.create(createEngineer());
        assertEquals(EngineerRepository.engineers.length, 8);
    }

    private Engineer createEngineer() {
        return new Engineer("0", "FName", "LName", "Func", "Cat", "Edu", 0, 0);
    }
}
