package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Engineer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputToEngineerTest {
    Engineer expected = new Engineer("temp", "Two", "One", "Three", "Four", "Five", 6, 7);

    @Test
    void getEngineerKeyTest() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -m -d {lastName:One firstName:Two function:Three category:Four education:Five experience:6 generalExperience:7}"));
    }

    @Test
    void getEngineerKeySymTest() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -m:& -d {lastName:One&firstName:Two&function:Three&category:Four&education:Five&experience:6&generalExperience:7}"));
    }

    @Test
    void getEngineerKeySymITest() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -m:| -d {lastName:One|firstName:Two|function:Three|category:Four|education:Five|experience:6|generalExperience:7}"));
    }

    @Test
    void getEngineerNull() {
        assertNull(UserInputToEngineer.getEngineer("new engineer -m:& -d {}"));
    }

    @Test
    void getEngineerKeyTwo() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -m:&214 -d {lastName:One&firstName:Two&function:Three&category:Four&education:Five&experience:6&generalExperience:7}"));
    }

    @Test
    void getEngineerKeyJson() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -json -d {\"lastName\":\"One\", \"firstName\":\"Two\", \"function\":\"Three\", \"category\":\"Four\", \"education\":\"Five\", \"experience\":\"6\", \"generalExperience\":\"7\"}"));
    }

    @Test
    void getEngineerKeyNotCaseTest() {
        assertNull(UserInputToEngineer.getEngineer("new engineer -md -d {lastName:One firstName:Two function:Three category:Four education:Five experience:6 generalExperience:7}"));
    }

    @Test
    void getEngineerKeyNotKeyDTest() {
        assertNull(UserInputToEngineer.getEngineer("new engineer -m {lastName:One firstName:Two function:Three category:Four education:Five experience:6 generalExperience:7}"));
    }

    @Test
    void getEngineerBracesTest() {
        assertNull(UserInputToEngineer.getEngineer("new engineer -m -d lastName:One firstName:Two function:Three category:Four education:Five experience:6 generalExperience:7}"));
    }
}
