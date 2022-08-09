package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

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
        assertEquals(5,carProvider.getCar().size());


    }
}