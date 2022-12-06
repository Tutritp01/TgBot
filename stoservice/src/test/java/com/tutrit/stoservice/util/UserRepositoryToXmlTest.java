package com.tutrit.stoservice.util;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRepositoryToXmlTest {

    File directory = Path.of("src", "main", "resources", "xml", "repository").toFile();

    UserRepository userRepository = new UserRepository();
    String id1 = "1";
    String id2 = "2";
    String id3 = "3";
    String id4 = "4";

    @BeforeEach
    void setUp() {
        userRepository.save(new User(id1, "user1", "phone1"));
        userRepository.save(new User(id2, "user2", "phone2"));
        userRepository.save(new User(id3, "user3", "phone3"));
        userRepository.save(new User(id4, "user4", "phone4"));
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
        UserRepositoryToXml.saveToXml(directory);
        int actual = Objects.requireNonNull(directory.listFiles()).length;
        assertEquals(userRepository.count(), actual);
        assertTrue(new File(directory, id1 + ".xml").exists());
        assertTrue(new File(directory, id2 + ".xml").exists());
        assertTrue(new File(directory, id3 + ".xml").exists());
        assertTrue(new File(directory, id4 + ".xml").exists());
    }
}
