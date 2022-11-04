package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GetOrderTest {
    Order expected = new Order();

    @BeforeEach
    void setUp() {
        expected.setUser("USER");
        expected.setCar("CAR");
        expected.setOrderStatus("ORDER-STATUS");
    }

    @Test
    void getEngineerKeyTest() {
        assertEquals(expected, GetOrder.getOrder("new order -m -d {user:USER car:CAR orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerKeySymTest() {
        assertEquals(expected, GetOrder.getOrder("new order -m:& -d {user:USER&car:CAR&orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerKeySymITest() {
        assertEquals(expected, GetOrder.getOrder("new order -m:| -d {user:USER|car:CAR|orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerNull() {
        assertNull(GetOrder.getOrder("new order -m:& -d {}"));
    }

    @Test
    void getEngineerKeyTwo() {
        assertEquals(expected, GetOrder.getOrder("new order -m:&214 -d {user:USER&car:CAR&orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerKeyJson() {
        assertEquals(expected, GetOrder.getOrder("new order -json -d {\"user\":\"USER\", \"car\":\"CAR\", \"orderStatus\":\"ORDER-STATUS\"}"));
    }

    @Test
    void getEngineerKeyNotCaseTest() {
        assertNull(GetOrder.getOrder("new order -md -d {user:USER car:CAR orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerKeyNotKeyDTest() {
        assertNull(GetOrder.getOrder("new order -m {user:USER car:CAR orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerBracesTest() {
        assertNull(GetOrder.getOrder("new order -m -d user:USER car:CAR orderStatus:ORDER-STATUS}"));
    }
}
