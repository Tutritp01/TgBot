package com.tutrit.tgbot.example.repository;

import com.tutrit.tgbot.example.bean.UserEmployee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryUserEmployeeTest {
    //private static final Logger log = LoggerFactory.getLogger(RepositoryUserEmployeeTest.class);
    RepositoryUserEmployee repositoryUserEmployee = new RepositoryUserEmployee();
    UserEmployee manager = new UserEmployee("Иванов", "Иван", "Главный менеджер", "Высшая", "Высшее", 5, 10);

    @Test
    void createEmployee() {
        repositoryUserEmployee.createEmployee(manager);
        System.out.println(Arrays.toString(repositoryUserEmployee.arrayEmployee));


    }
}