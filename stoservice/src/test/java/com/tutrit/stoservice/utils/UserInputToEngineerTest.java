package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Engineer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputToEngineerTest {
    Engineer expected = new Engineer("temp", "Two", "One", "Three", "Four", "Five", 6, 7);

    @Test
    void getEngineerKeyTest() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -m -d {LastName:One FirstName:Two Function:Three Category:Four Education:Five Experience:6 GeneralExperience:7}"));
    }

    @Test
    void getEngineerKeySymTest() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -m:& -d {LastName:One&FirstName:Two&Function:Three&Category:Four&Education:Five&Experience:6&GeneralExperience:7}"));
    }

    @Test
    void getEngineerKeySymITest() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -m:| -d {LastName:One|FirstName:Two|Function:Three|Category:Four|Education:Five|Experience:6|GeneralExperience:7}"));
    }

    @Test
    void getEngineerNull() {
        assertNull(UserInputToEngineer.getEngineer("new engineer -m:& -d {}"));
    }

    @Test
    void getEngineerKeyTwo() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -m:&214 -d {LastName:One&FirstName:Two&Function:Three&Category:Four&Education:Five&Experience:6&GeneralExperience:7}"));
    }

    @Test
    void getEngineerKeyJson() {
        assertEquals(expected, UserInputToEngineer.getEngineer("new engineer -json -d {\"LastName\":\"One\", \"FirstName\":\"Two\", \"Function\":\"Three\", \"Category\":\"Four\", \"Education\":\"Five\", \"Experience\":\"6\", \"GeneralExperience\":\"7\"}"));
    }

    @Test
    void getEngineerKeyNotCaseTest() {
        assertNull(UserInputToEngineer.getEngineer("new engineer -md -d {LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}"));
    }

    @Test
    void getEngineerKeyNotKeyDTest() {
        assertNull(UserInputToEngineer.getEngineer("new engineer -m {LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}"));
    }

    @Test
    void getEngineerBracesTest() {
        assertNull(UserInputToEngineer.getEngineer("new engineer -m LN:One FN:Two Fun:Three Cat:Four Edu:Five Exp:6 GExp:7}"));
    }

}