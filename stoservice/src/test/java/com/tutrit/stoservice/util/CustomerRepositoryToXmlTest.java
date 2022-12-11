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
import java.nio.file.Path;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerRepositoryToXmlTest {

    private final File directory = Path.of("src", "main", "resources", "xml", "repository").toFile();

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
    void deleteFiles() {
        for (File myFile : Objects.requireNonNull(directory.listFiles())) {
            if (myFile.isFile()) {
                myFile.delete();
            }
        }
    }

    @Test
    void saveToXml() {
        CustomerRepositoryToXml.saveToXml(directory);
        int actual = Objects.requireNonNull(directory.listFiles()).length;
        assertEquals(customerRepository.count(), actual);
        assertTrue(new File(directory, id1 + ".xml").exists());
        assertTrue(new File(directory, id2 + ".xml").exists());
        assertTrue(new File(directory, id3 + ".xml").exists());
        assertTrue(new File(directory, id4 + ".xml").exists());
    }
}
