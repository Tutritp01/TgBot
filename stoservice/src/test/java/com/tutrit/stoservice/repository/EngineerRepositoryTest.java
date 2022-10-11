package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EngineerRepositoryTest {

    private final EngineerRepository engineerRepository = new EngineerRepository();
    private final List<Engineer> engineerList = new ArrayList<>();
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

    @BeforeEach
    public void before() {
        Arrays.fill(EngineerRepository.engineers, null);
        EngineerRepository.counted = 0;
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
    }

    @Test
    void testSaveEngineerOne() {
        engineerRepository.save(engineer1);
        assertEquals(engineer1, EngineerRepository.engineers[0]);
    }

    @Test
    void testSaveEngineerOneI() {
        engineerRepository.save(engineer1i);
        assertEquals(engineer1, EngineerRepository.engineers[0]);
    }

    @Test
    void testCSaveEngineerTwo() {
        engineerRepository.save(engineer1);
        engineerRepository.save(engineer2);
        assertEquals(engineer1, EngineerRepository.engineers[0]);
        assertEquals(engineer2, EngineerRepository.engineers[1]);
    }

    @Test
    void testSaveEngineerTwoI() {
        engineerRepository.save(engineer1i);
        engineerRepository.save(engineer2i);
        assertEquals(engineer1, EngineerRepository.engineers[0]);
        assertEquals(engineer2, EngineerRepository.engineers[1]);
    }

    @Test
    void testSaveAll() {
        engineerList.add(engineer1i);
        engineerList.add(engineer2i);
        engineerList.add(engineer3i);
        engineerList.add(engineer4i);
        engineerList.add(engineer5i);
        engineerRepository.saveAll(engineerList);
        assertEquals(engineer1, EngineerRepository.engineers[0]);
        assertEquals(engineer2, EngineerRepository.engineers[1]);
        assertEquals(engineer3, EngineerRepository.engineers[2]);
        assertEquals(engineer4, EngineerRepository.engineers[3]);
        assertEquals(engineer5, EngineerRepository.engineers[4]);
    }


    @Test
    void testFind() {
        createFiveO();
        Engineer engineer = new Engineer("1", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        assertEquals(engineer, engineerRepository.find(engineer1));
    }

    @Test
    void testFindNull() {
        createFiveO();
        Engineer engineerF = new Engineer("10", "Тесто", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineerRepository.find(engineerF);
        assertNull(engineerRepository.find(engineerF));
    }

    @Test
    void testFindById() {
        createFiveF();
        assertEquals(engineer1, engineerRepository.findById("1"));
        assertEquals(engineer2, engineerRepository.findById("2"));
        assertEquals(engineer3, engineerRepository.findById("3"));
        assertEquals(engineer4, engineerRepository.findById("4"));
        assertEquals(engineer5, engineerRepository.findById("5"));
    }

    @Test
    void testFindByIdNull() {
        createFiveF();
        assertNull(engineerRepository.findById("10"));
    }

    @Test
    void testUpdateEngineer() {
        createFiveF();
        var engineerU = new Engineer("1", "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 8, 13);
        engineerRepository.update(engineerU);
        assertEquals(8, EngineerRepository.engineers[0].getExperience());
    }

    @Test
    void testDelete() {
        createFiveO();
        engineerRepository.delete(engineer3);
        engineerRepository.delete(engineer4);
        assertEquals(engineer1, EngineerRepository.engineers[0]);
        assertEquals(engineer2, EngineerRepository.engineers[1]);
        assertNull(EngineerRepository.engineers[2]);
    }

    @Test
    void testDeleteById() {
        createFiveO();
        engineerRepository.deleteById("4");
        assertNull(EngineerRepository.engineers[3]);
    }

    @Test
    void testCount() {
        createFiveO();
        engineerRepository.deleteById("4");
        assertNull(EngineerRepository.engineers[3]);
        engineerRepository.save(engineer4i);
        assertEquals("6", EngineerRepository.engineers[3].getIdEngineer());
    }

    @Test
    void testFindAll() {
        createFiveO();
        Iterable testIterable = engineerRepository.findAll();
        List testList = (List) testIterable;
        assertEquals(5, testList.size());
    }

    void createFiveF() {
        engineerRepository.save(engineer1);
        engineerRepository.save(engineer2);
        engineerRepository.save(engineer3);
        engineerRepository.save(engineer4);
        engineerRepository.save(engineer5);
    }

    void createFiveO() {
        engineerRepository.save(engineer1i);
        engineerRepository.save(engineer2i);
        engineerRepository.save(engineer3i);
        engineerRepository.save(engineer4i);
        engineerRepository.save(engineer5i);
    }
}
