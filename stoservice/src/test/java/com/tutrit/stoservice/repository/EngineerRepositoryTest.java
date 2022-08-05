package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EngineerRepositoryTest {

    private final EngineerRepository engineerRepository = new EngineerRepository();
    private Engineer engineer1;
    private Engineer engineer2;
    private Engineer engineer3;
    private Engineer engineer4;
    private Engineer engineer5;
    private Engineer engineer1i;
    private Engineer engineer2i;
    private Engineer engineer3i;
    private Engineer engineer4i;
    private Engineer engineer5i;
    private Engineer engineer5o = new Engineer("5", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
    private Engineer engineer4o = new Engineer("4", "Денис", "Пелля", "Мастер цеха", "высшая", "высшее", 3, 7);
    private Engineer engineer3o = new Engineer("3", "Юрий", "Божко>", "Главный инжинер", "высшая", "высшее", 1, 10);
    private Engineer engineer2o = new Engineer("2", "Роман", "Валюшко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
    private Engineer engineer1o = new Engineer("1", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);
    private final Engineer engineer5d = new Engineer("4", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);
    private final Engineer engineer5d2 = new Engineer("3", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);


    @BeforeEach
    public void before() {
        Arrays.fill(engineerRepository.engineers, null);

        engineer1 = new Engineer("1", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer2 = new Engineer("2", "Денис", "Пелля", "Мастер цеха", "высшая", "высшее", 3, 7);
        engineer3 = new Engineer("3", "Юрий", "Божко", "Главный инжинер", "высшая", "высшее", 1, 10);
        engineer4 = new Engineer("4", "Роман", "Валюшко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer5 = new Engineer("5", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);
        engineer1i = new Engineer("", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer2i = new Engineer("", "Денис", "Пелля", "Мастер цеха", "высшая", "высшее", 3, 7);
        engineer3i = new Engineer("", "Юрий", "Божко", "Главный инжинер", "высшая", "высшее", 1, 10);
        engineer4i = new Engineer("", "Роман", "Валюшко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer5i = new Engineer("", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);
        engineer5o = new Engineer("5", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer4o = new Engineer("4", "Денис", "Пелля", "Мастер цеха", "высшая", "высшее", 3, 7);
        engineer3o = new Engineer("3", "Юрий", "Божко", "Главный инжинер", "высшая", "высшее", 1, 10);
        engineer2o = new Engineer("2", "Роман", "Валюшко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer1o = new Engineer("1", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);

    }

    @Test
    void testCreateEngineerOne() {
        engineerRepository.createEngineer(engineer1);
        assertEquals(engineer1, engineerRepository.engineers[0]);
    }

    @Test
    void testCreateEngineerOneI() {
        engineerRepository.createEngineer(engineer1i);
        assertEquals(engineer1, engineerRepository.engineers[0]);
    }

    @Test
    void testCreateEngineerTwo() {
        EngineerRepository engineerRepository = new EngineerRepository();
        engineerRepository.createEngineer(engineer1);
        engineerRepository.createEngineer(engineer2);
        assertEquals(engineer1, engineerRepository.engineers[0]);
        assertEquals(engineer2, engineerRepository.engineers[1]);
    }

    @Test
    void testCreateEngineerTwoI() {
        EngineerRepository engineerRepository = new EngineerRepository();
        engineerRepository.createEngineer(engineer1i);
        engineerRepository.createEngineer(engineer2i);
        assertEquals(engineer1, engineerRepository.engineers[0]);
        assertEquals(engineer2, engineerRepository.engineers[1]);
    }

    @Test
    void testFindEngineerI() {
        createFive();
        assertEquals(engineer1, engineerRepository.findEngineer(1));
        assertEquals(engineer2, engineerRepository.findEngineer(2));
        assertEquals(engineer3, engineerRepository.findEngineer(3));
        assertEquals(engineer4, engineerRepository.findEngineer(4));
        assertEquals(engineer5, engineerRepository.findEngineer(5));
    }

    @Test
    void testFindEngineerO() {
        createFive();
        assertEquals(engineer1, (engineerRepository.findEngineer(engineer1i)));
        assertEquals(engineer2, (engineerRepository.findEngineer(engineer2i)));
        assertEquals(engineer3, (engineerRepository.findEngineer(engineer3i)));
        assertEquals(engineer4, (engineerRepository.findEngineer(engineer4i)));
        assertEquals(engineer5, (engineerRepository.findEngineer(engineer5i)));
        assertNotEquals(engineer1, (engineerRepository.findEngineer(engineer2i)));
        assertNotEquals(engineer1, (engineerRepository.findEngineer(engineer5i)));
        assertNotEquals(engineer2, (engineerRepository.findEngineer(engineer3i)));
        assertNotEquals(engineer2, (engineerRepository.findEngineer(engineer5i)));
        assertNotEquals(engineer3, (engineerRepository.findEngineer(engineer1i)));
        assertNotEquals(engineer3, (engineerRepository.findEngineer(engineer5i)));
        assertNotEquals(engineer4, (engineerRepository.findEngineer(engineer2i)));
        assertNotEquals(engineer4, (engineerRepository.findEngineer(engineer5i)));
        assertNotEquals(engineer5, (engineerRepository.findEngineer(engineer1i)));
        assertNotEquals(engineer5, (engineerRepository.findEngineer(engineer3i)));
    }

    @Test
    void testFindEngineerS() {
        createFive();
        assertEquals(engineer1, engineerRepository.findEngineer("1"));
        assertEquals(engineer2, engineerRepository.findEngineer("2"));
        assertEquals(engineer3, engineerRepository.findEngineer("3"));
        assertEquals(engineer4, engineerRepository.findEngineer("4"));
        assertEquals(engineer5, engineerRepository.findEngineer("5"));
    }

    @Test
    void testUpdateEngineer() {
        createFive();
        engineerRepository.updateEngineer(engineer5i, 1);
        engineerRepository.updateEngineer(engineer4i, 2);
        engineerRepository.updateEngineer(engineer2i, 4);
        engineerRepository.updateEngineer(engineer1i, 5);
        assertEquals(engineer1o, engineerRepository.engineers[0]);
        assertEquals(engineer2o, engineerRepository.engineers[1]);
        assertEquals(engineer3o, engineerRepository.engineers[2]);
        assertEquals(engineer4o, engineerRepository.engineers[3]);
        assertEquals(engineer5o, engineerRepository.engineers[4]);
        assertNotEquals(engineer1, engineerRepository.engineers[0]);
        assertNotEquals(engineer1i, engineerRepository.engineers[0]);
        assertNotEquals(engineer2, engineerRepository.engineers[1]);
        assertNotEquals(engineer2i, engineerRepository.engineers[1]);
        assertEquals(engineer3, engineerRepository.engineers[2]);
        assertNotEquals(engineer4, engineerRepository.engineers[3]);
        assertNotEquals(engineer4i, engineerRepository.engineers[3]);
        assertNotEquals(engineer5, engineerRepository.engineers[4]);
        assertNotEquals(engineer5i, engineerRepository.engineers[4]);
    }

    @Test
    void testDeleteEngineerI() {
        createFive();
        engineerRepository.deleteEngineer(4);
        assertNotEquals(engineer4, engineerRepository.engineers[3]);
        assertEquals(engineer5d, engineerRepository.engineers[3]);
    }

    @Test
    void testDeleteEngineerO() {
        createFive();
        engineerRepository.deleteEngineer(engineer3i);
        engineerRepository.deleteEngineer(engineer4i);
        assertEquals(engineer1, engineerRepository.engineers[0]);
        assertEquals(engineer2, engineerRepository.engineers[1]);
        assertEquals(engineer5d2, engineerRepository.engineers[2]);
    }

    @Test
    void testDeleteEngineerS() {
        createFive();
        engineerRepository.deleteEngineer("4");
        assertNotEquals(engineer4, engineerRepository.engineers[3]);
        assertEquals(engineer5d, engineerRepository.engineers[3]);
    }

    @Test
    void count() {
        assertEquals("1", engineerRepository.count(0));
        assertEquals("6", engineerRepository.count(5));
        assertNotEquals("5", engineerRepository.count(5));
        assertNotEquals("4", engineerRepository.count(5));
        assertNotEquals("7", engineerRepository.count(5));
    }

    void createFive() {
        engineerRepository.createEngineer(engineer1i);
        engineerRepository.createEngineer(engineer2i);
        engineerRepository.createEngineer(engineer3i);
        engineerRepository.createEngineer(engineer4i);
        engineerRepository.createEngineer(engineer5i);
    }
}
