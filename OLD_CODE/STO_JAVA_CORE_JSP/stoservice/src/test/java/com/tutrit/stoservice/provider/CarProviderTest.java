package com.tutrit.stoservice.provider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarProviderTest {
    CarProvider carProvider;

    @BeforeEach
    void setUp() {
        carProvider = new CarProvider();
    }

    @Test
    void getInstance() {


    }

    @Test
    void getCar() {
        carProvider.getCar();
        assertEquals(5, carProvider.getCar().size());
    }
}