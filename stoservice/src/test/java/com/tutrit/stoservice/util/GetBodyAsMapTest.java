package com.tutrit.stoservice.util;

import com.tutrit.stoservice.controller.Request;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GetBodyAsMapTest {

    @Test
    void parseUserInput() {

            HashMap<String, String> values = new HashMap<>();
            values.put("idEngineer", "zero");
            values.put("lastName", "One");
            values.put("firstName", "Two");
            values.put("function", "Three");
            values.put("category", "Four");
            values.put("education", "Five");
            values.put("experience", "6");
            values.put("generalExperience", "7");
            Request request = new Request("new engineer -d idEngineer=zero&lastName=One&firstName=Two&function=Three&category=Four&education=Five&experience=6&generalExperience=7");
            assertEquals(values, GetBodyAsMap.separateBodyFromCommand(request));

        }
    }
