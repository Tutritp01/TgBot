package com.tutrit.stoservice.util;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.repository.UserRepository;
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

class UserRepositoryToOurFormatTest {

    private final File directory = Path.of("src", "main", "resources", "our", "repository").toFile();

    private UserRepository userRepository;
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
        userRepository = ApplicationContext.get(UserRepository.class);
        userRepository.save(new User(id1, "user1", "phone1"));
        userRepository.save(new User(id2, "user2", "phone2"));
        userRepository.save(new User(id3, "user3", "phone3"));
        userRepository.save(new User(id4, "user4", "phone4"));
    }

    @AfterEach
    void clear() {
        clearRepository();
        clearDirectory();
    }

    @Test
    void saveToFormat() throws IOException, IllegalAccessException {
        UserRepositoryToOurFormat.saveToFormat(directory);
        int actual = Objects.requireNonNull(directory.listFiles()).length;
        assertEquals(userRepository.count(), actual);
        assertTrue(new File(directory, id1).exists());
        assertTrue(new File(directory, id2).exists());
        assertTrue(new File(directory, id3).exists());
        assertTrue(new File(directory, id4).exists());
    }

    private void clearRepository() {
        ((Collection<?>) userRepository.findAll()).clear();
    }

    private void clearDirectory() {
        for (File myFile : Objects.requireNonNull(directory.listFiles())) {
            if (myFile.exists()) {
                myFile.delete();
            }
        }
    }
}
