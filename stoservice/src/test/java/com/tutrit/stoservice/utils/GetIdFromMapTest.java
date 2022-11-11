package com.tutrit.stoservice.utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GetIdFromMapTest {
    Map<String, String> map = Map.of("id", "1");
    Map<String, String> mapNullId = Map.of("name", "1");
    @Test
    void getId() {
        assertEquals("1", GetIdFromMap.getId(map));
    }

    @Test
    void getIdNull() {
        assertNull( GetIdFromMap.getId(mapNullId));
    }
}