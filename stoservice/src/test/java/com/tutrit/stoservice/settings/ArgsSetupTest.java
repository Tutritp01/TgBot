package com.tutrit.stoservice.settings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArgsSetupTest {
    Configurations configurations;
    ArgsSetup argsSetup;

    @BeforeEach
    void setUp() {
        configurations = new Configurations();
        argsSetup = new ArgsSetup(configurations);
    }

    @Test
    void readingFlagsEnable() {
        assertFalse(configurations.isLoadDataDemo());
        String[] args = new String[] { "-eld"};
        argsSetup.readingFlags(args);
        assertTrue(configurations.isLoadDataDemo());
    }

    @Test
    void readingFlagsDisable() {
        assertFalse(configurations.isLoadDataDemo());
        configurations.setLoadDataDemo(true);
        assertTrue(configurations.isLoadDataDemo());
        String[] args = new String[] { "-dld"};
        argsSetup.readingFlags(args);
        assertFalse(configurations.isLoadDataDemo());
    }

    @Test
    void readingFlagsNull() {
        assertFalse(configurations.isLoadDataDemo());
        argsSetup.readingFlags(null);
        assertFalse(configurations.isLoadDataDemo());
    }
}
