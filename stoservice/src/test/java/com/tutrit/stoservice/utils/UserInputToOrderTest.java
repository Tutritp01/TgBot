package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserInputToOrderTest {
    Order expected = new Order();

    @BeforeEach
    void setUp() {
        expected.setUser("USER");
        expected.setCar("CAR");
        expected.setOrderStatus("ORDER-STATUS");
    }

    @Test
    void getEngineerKeyTest() {
        assertEquals(expected, UserInputToOrder.getOrder("new order -m -d {user:USER car:CAR orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerKeySymTest() {
        assertEquals(expected, UserInputToOrder.getOrder("new order -m:& -d {user:USER&car:CAR&orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerKeySymITest() {
        assertEquals(expected, UserInputToOrder.getOrder("new order -m:| -d {user:USER|car:CAR|orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerNull() {
        assertNull(UserInputToOrder.getOrder("new order -m:& -d {}"));
    }

    @Test
    void getEngineerKeyTwo() {
        assertEquals(expected, UserInputToOrder.getOrder("new order -m:&214 -d {user:USER&car:CAR&orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerKeyJson() {
        assertEquals(expected, UserInputToOrder.getOrder("new order -json -d {\"user\":\"USER\", \"car\":\"CAR\", \"orderStatus\":\"ORDER-STATUS\"}"));
    }

    @Test
    void getEngineerKeyNotCaseTest() {
        assertNull(UserInputToOrder.getOrder("new order -md -d {user:USER car:CAR orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerKeyNotKeyDTest() {
        assertNull(UserInputToOrder.getOrder("new order -m {user:USER car:CAR orderStatus:ORDER-STATUS}"));
    }

    @Test
    void getEngineerBracesTest() {
        assertNull(UserInputToOrder.getOrder("new order -m -d user:USER car:CAR orderStatus:ORDER-STATUS}"));
    }
}
