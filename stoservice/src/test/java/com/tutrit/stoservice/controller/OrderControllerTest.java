package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContextLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tutrit.stoservice.context.ApplicationContext.get;

class OrderControllerTest {
    OrderController orderController;

    @BeforeAll
    public static void setUpContext() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    public void setUp() {
        orderController = get(OrderController.class);
    }

    @Test
    void doCommand() {
        var request = new Request("new order");
        var response = new Response();
        orderController.doCommand(request, response);
    }
}