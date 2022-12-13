package com.tutrit.stoservice.settings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConfigurationsTest {
    Configurations configurations;

    @BeforeEach
    void setUp() {
        configurations = new Configurations("src/test/resources/configFalse.properties");
    }

    @Test
    void setPathToProperties() {
        configurations.setPathToProperties("src/test/resources/config.properties");
        configurations.getProperties();
        assertTrue(configurations.isLoadDataDemo());
        configurations.setPathToProperties("src/test/resources/configFalse.properties");
        configurations.getProperties();
        assertFalse(configurations.isLoadDataDemo());
    }

    @Test
    void isLoadDataDemo() {
        assertFalse(configurations.isLoadDataDemo());
        configurations.setPathToProperties("src/test/resources/config.properties");
        configurations.getProperties();
        assertTrue(configurations.isLoadDataDemo());
    }

    @Test
    void getProperties() {
        configurations.setPathToProperties("src/test/resources/config.properties");
        configurations.getProperties();
        assertTrue(configurations.isLoadDataDemo());
    }

    @Test
    void getPropertiesNoFile() {
        configurations.setPathToProperties("src/test/resources/get.properties");
        configurations.getProperties();
        assertFalse(configurations.isLoadDataDemo());
    }
}