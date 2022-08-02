package com.example.demo.repository;

import com.example.demo.bean.Engineer;
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
    private Engineer engineer3o = new Engineer("3", "Юрий", "Яковлев", "Главный инжинер", "высшая", "высшее", 1, 10);
    private Engineer engineer2o = new Engineer("2", "Роман", "Валюшко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
    private Engineer engineer1o = new Engineer("1", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);
    private final Engineer engineer5d = new Engineer("4", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);

    @BeforeEach
    public void before() {
        Arrays.fill(engineerRepository.engineers, null);

        engineer1 = new Engineer("1", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer2 = new Engineer("2", "Денис", "Пелля", "Мастер цеха", "высшая", "высшее", 3, 7);
        engineer3 = new Engineer("3", "Юрий", "Яковлев", "Главный инжинер", "высшая", "высшее", 1, 10);
        engineer4 = new Engineer("4", "Роман", "Валюшко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer5 = new Engineer("5", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);
        engineer1i = new Engineer("", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer2i = new Engineer("", "Денис", "Пелля", "Мастер цеха", "высшая", "высшее", 3, 7);
        engineer3i = new Engineer("", "Юрий", "Яковлев", "Главный инжинер", "высшая", "высшее", 1, 10);
        engineer4i = new Engineer("", "Роман", "Валюшко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer5i = new Engineer("", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);
        engineer5o = new Engineer("5", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer4o = new Engineer("4", "Денис", "Пелля", "Мастер цеха", "высшая", "высшее", 3, 7);
        engineer3o = new Engineer("3", "Юрий", "Яковлев", "Главный инжинер", "высшая", "высшее", 1, 10);
        engineer2o = new Engineer("2", "Роман", "Валюшко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineer1o = new Engineer("1", "Роман", "Валюшко", "Главный менеджер", "высшая", "высшее", 5, 10);

    }

    @Test
    void createEngineerOne() {
        engineerRepository.createEngineer(engineer1);
        assertEquals(engineerRepository.engineers[0], engineer1);
    }

    @Test
    void createEngineerOneI() {
        engineerRepository.createEngineer(engineer1i);
        assertEquals(engineerRepository.engineers[0], engineer1);
    }

    @Test
    void createEngineerTwo() {
        EngineerRepository engineerRepository = new EngineerRepository();
        engineerRepository.createEngineer(engineer1);
        engineerRepository.createEngineer(engineer2);
        assertEquals(engineerRepository.engineers[0], engineer1);
        assertEquals(engineerRepository.engineers[1], engineer2);
    }

    @Test
    void createEngineerTwoI() {
        EngineerRepository engineerRepository = new EngineerRepository();
        engineerRepository.createEngineer(engineer1i);
        engineerRepository.createEngineer(engineer2i);
        assertEquals(engineerRepository.engineers[0], engineer1);
        assertEquals(engineerRepository.engineers[1], engineer2);
    }

    @Test
    void readEngineer() {
        createFive();
        assertEquals(engineerRepository.readEngineer(1), engineer1);
        assertEquals(engineerRepository.readEngineer(2), engineer2);
        assertEquals(engineerRepository.readEngineer(3), engineer3);
        assertEquals(engineerRepository.readEngineer(4), engineer4);
        assertEquals(engineerRepository.readEngineer(5), engineer5);
    }

    @Test
    void updateEngineer() {
        createFive();
        engineerRepository.updateEngineer(engineer5i, 1);
        engineerRepository.updateEngineer(engineer4i, 2);
        engineerRepository.updateEngineer(engineer2i, 4);
        engineerRepository.updateEngineer(engineer1i, 5);
        assertEquals(engineerRepository.engineers[0], engineer1o);
        assertEquals(engineerRepository.engineers[1], engineer2o);
        assertEquals(engineerRepository.engineers[2], engineer3o);
        assertEquals(engineerRepository.engineers[3], engineer4o);
        assertEquals(engineerRepository.engineers[4], engineer5o);
        assertNotEquals(engineerRepository.engineers[0], engineer1);
        assertNotEquals(engineerRepository.engineers[0], engineer1i);
        assertNotEquals(engineerRepository.engineers[1], engineer2);
        assertNotEquals(engineerRepository.engineers[1], engineer2i);
        assertEquals(engineerRepository.engineers[2], engineer3);
        assertNotEquals(engineerRepository.engineers[3], engineer4);
        assertNotEquals(engineerRepository.engineers[3], engineer4i);
        assertNotEquals(engineerRepository.engineers[4], engineer5);
        assertNotEquals(engineerRepository.engineers[4], engineer5i);
    }

    @Test
    void deleteEngineer() {
        createFive();
        engineerRepository.deleteEngineer(4);
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