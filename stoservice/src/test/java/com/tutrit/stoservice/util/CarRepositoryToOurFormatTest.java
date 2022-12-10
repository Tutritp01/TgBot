package com.tutrit.stoservice.util;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarRepositoryToOurFormatTest {

    private final File directory = Path.of("src", "main", "resources", "our", "repository").toFile();

    private CarRepository carRepository;
    private final String id1 = "1";
    private final String id2 = "2";
    private final String id3 = "3";
    private final String id4 = "4";

    @BeforeAll
    public static void load() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    void setUp() {
        carRepository = ApplicationContext.get(CarRepository.class);
        carRepository.save(new Car(id1, "owner", "vin", "plateNumber", "brand1", "model1", "1g", "mod1", "engine1", 2001));
        carRepository.save(new Car(id2, "owner", "vin", "plateNumber", "brand2", "model2", "2g", "mod2", "engine2", 2002));
        carRepository.save(new Car(id3, "owner", "vin", "plateNumber", "brand3", "model3", "3g", "mod3", "engine3", 2003));
        carRepository.save(new Car(id4, "owner", "vin", "plateNumber", "brand4", "model4", "4g", "mod4", "engine4", 2004));
    }

    @AfterEach
    void clear() {
        clearRepository();
        clearDirectory();
    }

    @Test
    void saveToFormat() throws IOException, IllegalAccessException {
        CarRepositoryToOurFormat.saveToFormat(directory);
        int actual = Objects.requireNonNull(directory.listFiles()).length;
        assertEquals(carRepository.count(), actual);
        assertTrue(new File(directory, id1).exists());
        assertTrue(new File(directory, id2).exists());
        assertTrue(new File(directory, id3).exists());
        assertTrue(new File(directory, id4).exists());
    }

    private void clearRepository() {
        ((Collection<?>) carRepository.findAll()).clear();
    }

    private void clearDirectory() {
        for (File myFile : Objects.requireNonNull(directory.listFiles())) {
            if (myFile.exists()) {
                myFile.delete();
            }
        }
    }
}
