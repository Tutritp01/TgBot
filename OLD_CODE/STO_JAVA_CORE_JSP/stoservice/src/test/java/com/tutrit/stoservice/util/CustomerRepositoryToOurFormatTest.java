package com.tutrit.stoservice.util;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.repository.CustomerRepository;
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

class CustomerRepositoryToOurFormatTest {

    private final File directory = Path.of("src", "main", "resources", "our", "repository").toFile();

    private CustomerRepository customerRepository;
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
        customerRepository = ApplicationContext.get(CustomerRepository.class);
        customerRepository.save(new Customer(id1, "customer1", "city1", "phone1", "email1"));
        customerRepository.save(new Customer(id2, "customer2", "city2", "phone2", "email2"));
        customerRepository.save(new Customer(id3, "customer3", "city3", "phone3", "email3"));
        customerRepository.save(new Customer(id4, "customer4", "city4", "phone4", "email4"));
    }

    @AfterEach
    void clear() {
        clearRepository();
        clearDirectory();
    }

    @Test
    void saveToFormat() throws IOException, IllegalAccessException {
        CustomerRepositoryToOurFormat.saveToFormat(directory);
        int actual = Objects.requireNonNull(directory.listFiles()).length;
        assertEquals(customerRepository.count(), actual);
        assertTrue(new File(directory, id1).exists());
        assertTrue(new File(directory, id2).exists());
        assertTrue(new File(directory, id3).exists());
        assertTrue(new File(directory, id4).exists());
    }

    private void clearRepository() {
        ((Collection<?>) customerRepository.findAll()).clear();
    }

    private void clearDirectory() {
        for (File myFile : Objects.requireNonNull(directory.listFiles())) {
            if (myFile.exists()) {
                myFile.delete();
            }
        }
    }
}
