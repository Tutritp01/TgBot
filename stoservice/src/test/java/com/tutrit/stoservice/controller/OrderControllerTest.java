package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderControllerTest {
    OrderController orderController;
    OrderServiceMock orderServiceMock;

    @BeforeAll
    public static void setUpContext() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    public void setUp() {
        orderController = get(OrderController.class);
        orderServiceMock = new OrderServiceMock();
        orderController.setOrderService(orderServiceMock);
    }

    @Test
    void doCommand() {
        var request = new Request("new order");
        var response = new Response();
        orderController.doCommand(request, response);

        Order expectedOrder = new Order();
        assertEquals(expectedOrder, orderServiceMock.capturedOrder);
        assertEquals("new order has been saved", response.getResponse());
    }
}