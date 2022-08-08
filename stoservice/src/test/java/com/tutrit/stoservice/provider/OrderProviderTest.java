package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderProviderTest {
    OrderRepository orderRepository;
    Order orderExpected1 = new Order("id1","UserName", "UserCar", "Open");
    Order orderExpected2 = new Order("id2","UserName", "UserCar", "Open");
    Order orderExpected3 = new Order("id3","UserName", "UserCar", "Open");
    Order orderExpected4 = new Order("id4","UserName", "UserCar", "Open");
    Order orderExpected5 = new Order("id5","UserName", "UserCar", "Open");
    Order orderExpected6 = new Order("id6","UserName", "UserCar", "Open");
    Order orderExpected7 = new Order("id7","UserName", "UserCar", "Open");
    Order orderExpected8 = new Order("id8","UserName", "UserCar", "Open");
    Order orderExpected9 = new Order("id9","UserName", "UserCar", "Open");
    Order orderExpected10 = new Order("id10","UserName", "UserCar", "Open");

    @Test
    void testGetOrder() {
        Order orderOne = new Order();
        OrderProvider.getOrder(orderOne, 1);
        assertEquals(orderExpected1, orderOne);
        Order orderTwo = new Order();
        OrderProvider.getOrder(orderTwo, 2);
        assertEquals(orderExpected2, orderTwo);
        assertNotEquals(orderOne, orderTwo);
    }

    @Test
    void testCreateTenOrder() {
        orderRepository = OrderProvider.createTenOrder();
        assertEquals(orderExpected1, orderRepository.orders.get("id1"));
        assertEquals(orderExpected2, orderRepository.orders.get("id2"));
        assertEquals(orderExpected3, orderRepository.orders.get("id3"));
        assertEquals(orderExpected4, orderRepository.orders.get("id4"));
        assertEquals(orderExpected5, orderRepository.orders.get("id5"));
        assertEquals(orderExpected6, orderRepository.orders.get("id6"));
        assertEquals(orderExpected7, orderRepository.orders.get("id7"));
        assertEquals(orderExpected8, orderRepository.orders.get("id8"));
        assertEquals(orderExpected9, orderRepository.orders.get("id9"));
        assertEquals(orderExpected10, orderRepository.orders.get("id10"));
        assertNull(orderRepository.orders.get("id0"));
        assertNull(orderRepository.orders.get("id11"));
    }
}
