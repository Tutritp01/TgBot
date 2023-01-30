package com.tutrit.stoservice.util;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.repository.EngineerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EngineerRepositoryToOurFormatTest {

    private final File directory = Path.of("src", "main", "resources", "our", "repository").toFile();

    private EngineerRepository engineerRepository;
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
        engineerRepository = ApplicationContext.get(EngineerRepository.class);
        engineerRepository.save(new Engineer(id1, "Нестор", "Майко", "Инженер по гарантии", "высшая", "высшее", 5, 10));
        engineerRepository.save(new Engineer(id2, "Денис", "Пелля", "Мастер цеха", "высшая", "высшее", 3, 7));
        engineerRepository.save(new Engineer(id3, "Юрий", "Божко", "Главный инженер", "высшая", "высшее", 1, 10));
        engineerRepository.save(new Engineer(id4, "Роман", "Валюшко", "Инженер по гарантии", "высшая", "высшее", 5, 10));
    }

    @AfterEach
    void clear() {
        clearRepository();
        clearDirectory();
    }

    @Test
    void saveToFormat() throws IOException, IllegalAccessException {
        EngineerRepositoryToOurFormat.saveToFormat(directory);
        int actual = Objects.requireNonNull(directory.listFiles()).length;
        assertEquals(engineerRepository.count(), actual);
        assertTrue(new File(directory, id1).exists());
        assertTrue(new File(directory, id2).exists());
        assertTrue(new File(directory, id3).exists());
        assertTrue(new File(directory, id4).exists());
    }

    private void clearRepository() {
        for (Engineer engineer : engineerRepository.findAll()) {
            engineerRepository.delete(engineer);
        }
    }

    private void clearDirectory() {
        for (File myFile : Objects.requireNonNull(directory.listFiles())) {
            if (myFile.isFile()) {
                myFile.delete();
            }
        }
    }
}
