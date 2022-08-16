package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Order;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderProviderTest {
    Map<String, Order> testMap = new HashMap<>();
    Map<String, Order> testMap2 = new HashMap<>();
    Order order0 = new Order("Id", "User", "Car", "Open");
    Order order1 = new Order("Id0", "User0", "Car0", "Open0");
    Order order2 = new Order("Id1", "User1", "Car1", "Open1");
    Order order3 = new Order("Id2", "User2", "Car2", "Open2");
    Order order4 = new Order("Id3", "User3", "Car3", "Open3");
    Order order5 = new Order("Id4", "User4", "Car4", "Open4");
    Order order6 = new Order("Id5", "User5", "Car5", "Open5");
    Order order7 = new Order("Id6", "User6", "Car6", "Open6");
    Order order8 = new Order("Id7", "User7", "Car7", "Open7");
    Order order9 = new Order("Id8", "User8", "Car8", "Open8");
    Order order10 = new Order("Id9", "User9", "Car9", "Open9");

    public void setTestMap10() {
        testMap.put(order1.getId(), order1);
        testMap.put(order2.getId(), order2);
        testMap.put(order3.getId(), order3);
        testMap.put(order4.getId(), order4);
        testMap.put(order5.getId(), order5);
        testMap.put(order6.getId(), order6);
        testMap.put(order7.getId(), order7);
        testMap.put(order8.getId(), order8);
        testMap.put(order9.getId(), order9);
        testMap.put(order10.getId(), order10);
    }

    public void setTestMap3() {
        testMap2.put(order1.getId(), order1);
        testMap2.put(order2.getId(), order2);
        testMap2.put(order3.getId(), order3);
    }

    @Test
    void testGetOrders() {
        setTestMap10();
        assertArrayEquals(testMap.keySet().toArray(), OrderProvider.getOrders().keySet().toArray());
        assertArrayEquals(testMap.values().toArray(), OrderProvider.getOrders().values().toArray());
    }

    @Test
    void testGetOrdersI() {
        setTestMap3();
        assertArrayEquals(testMap2.keySet().toArray(), OrderProvider.getOrders(3).keySet().toArray());
        assertArrayEquals(testMap2.values().toArray(), OrderProvider.getOrders(3).values().toArray());
        }

    @Test
    void testGetInstanceI() {
        assertEquals(OrderProvider.getInstance(1), order2);
    }

    @Test
    void testGetInstance() {
        assertEquals(OrderProvider.getInstance(), order0);
    }
}
