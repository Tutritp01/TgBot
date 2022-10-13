package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputToEngineerServiceTest {
    Engineer expected = new Engineer("temp", "Two", "One", "Three", "Four", "Five", 6, 7);

    @Test
    void getEngineerKeyTest() {
        assertEquals(expected, UserInputToEngineerService.getEngineer("new engineer -m -d {LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}"));
    }

    @Test
    void getEngineerKeySymTest() {
        assertEquals(expected, UserInputToEngineerService.getEngineer("new engineer -m:& -d {LN:One&FN:Two&Fun:Three&Cat:Four&Edu:Five&Exp:6&GExp:7}"));
    }

    @Test
    void getEngineerKeySymITest() {
        assertEquals(expected, UserInputToEngineerService.getEngineer("new engineer -m:| -d {LN:One|FN:Two|Fun:Three|Cat:Four|Edu:Five|Exp:6|GExp:7}"));
    }

    @Test
    void getEngineerNull() {
        assertNull(UserInputToEngineerService.getEngineer("new engineer -m:& -d {}"));
    }

    @Test
    void getEngineerKeyTwo() {
        assertEquals(expected, UserInputToEngineerService.getEngineer("new engineer -m:&214 -d {LN:One&FN:Two&Fun:Three&Cat:Four&Edu:Five&Exp:6&GExp:7}"));
    }

    @Test
    void getEngineerKeyJson() {
        assertEquals(expected, UserInputToEngineerService.getEngineer("new engineer -json -d {\"LN\":\"One\", \"FN\":\"Two\", \"Fun\":\"Three\", \"Cat\":\"Four\", \"Edu\":\"Five\", \"Exp\":\"6\", \"GExp\":\"7\"}"));
    }

    @Test
    void getEngineerKeyNotCaseTest() {
        assertNull(UserInputToEngineerService.getEngineer("new engineer -md -d {LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}"));
    }

    @Test
    void getEngineerKeyNotKeyDTest() {
        assertNull(UserInputToEngineerService.getEngineer("new engineer -m {LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}"));
    }

    @Test
    void getEngineerBracesTest() {
        assertNull(UserInputToEngineerService.getEngineer("new engineer -m LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}"));
    }
}
