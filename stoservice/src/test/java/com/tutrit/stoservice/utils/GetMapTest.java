package com.tutrit.stoservice.utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetMapTest {
    Map<String, String> expected = Map.of("One", "OneValue", "Two", "TwoValue", "Three", "ThreeValue");

    @Test
    void getMapTest() {
        assertEquals(expected, GetMap.getMap("Text msg -m -d {One:OneValue Two:TwoValue Three:ThreeValue}"));
    }

    @Test
    void getMap() {
        assertEquals(expected, GetMap.getMap("Text msg -d {One:OneValue Two:TwoValue Three:ThreeValue}"));
    }
}
