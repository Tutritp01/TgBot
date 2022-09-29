package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderProviderTest {
    List<Order> testList = new ArrayList<>();
    List<Order> testList2 = new ArrayList<>();
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
        testList.add(order1);
        testList.add(order2);
        testList.add(order3);
        testList.add(order4);
        testList.add(order5);
        testList.add(order6);
        testList.add(order7);
        testList.add(order8);
        testList.add(order9);
        testList.add(order10);
    }

    public void setTestMap3() {
        testList2.add(order1);
        testList2.add(order2);
        testList2.add(order3);
    }

    @Test
    void testGetOrders() {
        setTestMap10();
        assertEquals(testList, OrderProvider.getOrders());
    }

    @Test
    void testGetOrdersI() {
        setTestMap3();
        assertEquals(testList2, OrderProvider.getOrders(3));
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
