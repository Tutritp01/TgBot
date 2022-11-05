package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderControllerTest {
    OrderController orderController;
    Command command;
    Request request;
    Response response;

    @BeforeEach
    void SetUp() {
        ApplicationContextLoader.run();
        orderController = ApplicationContext.get(OrderController.class);
        response = new Response();
        ApplicationContext.get(OrderRepository.class).orders.clear();
        OrderRepository.counted = 0;
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "new order -m -d {user:USER car:CAR orderStatus:ORDER-STATUS}",
            "new order -m -d {user:USER car:CAR orderStatus:ORDER-STATUS}"
    })
    void doCommandFirst(String msgTxt) {
        request = new Request(msgTxt);
        orderController.doCommand(request, response);
        assertEquals("Order 1 is created", response.getResponse());
    }

    @Test
    void doCommandFailRequest() {
        request = new Request("new order -m -d user:USER car:CAR orderStatus:ORDER-STATUS}");
        orderController.doCommand(request, response);
        assertEquals("Order not created", response.getResponse());
    }

    @Test
    void getCommandToString() {
        command = orderController.getCommand();
        assertEquals("NEW_ORDER", command.toString());
    }

    @Test
    void getCommandString() {
        command = orderController.getCommand();
        assertEquals("new order", command.commands);
    }
}