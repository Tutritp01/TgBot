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
import java.nio.file.Path;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EngineerRepositoryToXmlTest {
    private final File directory = Path.of("src", "main", "resources", "xml", "repository").toFile();

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
        engineerRepository.save(new Engineer(id1, "firstName1", "lastName1", "function1", "category1", "education1", 1, 1));
        engineerRepository.save(new Engineer(id2, "firstName2", "lastName2", "function2", "category2", "education2", 2, 2));
        engineerRepository.save(new Engineer(id3, "firstName3", "lastName3", "function3", "category3", "education3", 3, 3));
        engineerRepository.save(new Engineer(id4, "firstName4", "lastName4", "function4", "category4", "education4", 4, 4));
    }

    @AfterEach
    void deleteFiles() {
        for (File myFile : Objects.requireNonNull(directory.listFiles())) {
            if (myFile.isFile()) {
                myFile.delete();
            }
        }
    }

    @Test
    void saveToXml() {
        EngineerRepositoryToXml.saveToXml(directory);
        int actual = Objects.requireNonNull(directory.listFiles()).length;
        assertEquals(engineerRepository.count(), actual);
        assertTrue(new File(directory, id1 + ".xml").exists());
        assertTrue(new File(directory, id2 + ".xml").exists());
        assertTrue(new File(directory, id3 + ".xml").exists());
        assertTrue(new File(directory, id4 + ".xml").exists());
    }
}
