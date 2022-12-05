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
        getCommandToStringNew();
        getCommandStringNew();
    }

    @Test
    void doCommandFailRequest() {
        request = new Request("new order -m -d user:USER car:CAR orderStatus:ORDER-STATUS}");
        orderController.doCommand(request, response);
        assertEquals("Order not created", response.getResponse());
    }

    @Test
    void doCommandGetOrder () {
        request = new Request("new order -m -d {user:USER car:CAR orderStatus:ORDER-STATUS}");
        orderController.doCommand(request, response);
        orderController.doCommand(request, response);
        request = new Request("get order -m -d {id:1}");
        orderController.doCommand(request, response);
        assertEquals("Order with ID: 1 found", response.getResponse());
        request = new Request("get order -m -d {id:2}");
        orderController.doCommand(request, response);
        assertEquals("Order with ID: 2 found", response.getResponse());
        getCommandToStringGet();
        getCommandStringGet();
    }

    @Test
    void doCommandGetOrderNoId() {
        request = new Request("new order -m -d {user:USER car:CAR orderStatus:ORDER-STATUS}");
        orderController.doCommand(request, response);
        orderController.doCommand(request, response);
        request = new Request("get order -m -d {id:}");
        orderController.doCommand(request, response);
        assertEquals("Incorrectly entered command, failed to find the ID", response.getResponse());
    }

    @Test
    void doCommandGetOrderNotFound() {
        request = new Request("new order -m -d {user:USER car:CAR orderStatus:ORDER-STATUS}");
        orderController.doCommand(request, response);
        orderController.doCommand(request, response);
        request = new Request("get order -m -d {id:1}");
        orderController.doCommand(request, response);
        assertEquals("Order with ID: 1 found", response.getResponse());
        request = new Request("get order -m -d {id:3}");
        orderController.doCommand(request, response);
        assertEquals("Error 404: Order with 3 not found", response.getResponse());

    }

    void getCommandToStringNew() {
        command = orderController.getCommand();
        assertEquals("NEW_ORDER", command.toString());
    }

    void getCommandStringNew() {
        command = orderController.getCommand();
        assertEquals("new order", command.commands);
    }

    void getCommandToStringGet() {
        command = orderController.getCommand();
        assertEquals("GET_ORDER", command.toString());
    }

    void getCommandStringGet() {
        command = orderController.getCommand();
        assertEquals("get order", command.commands);
    }
    @Test
    void integrationOrderControllerTest() {
        Response response = new Response();
        Request request = new Request("new order " +
                "-d car.id=zero" +
                "&car.owner=Vlad" +
                "&vin=car.vw1989zzz1234321" +
                "&car.plateNumber=0000AA1" +
                "&car.brand=volkswagen" +
                "&car.model=golf" +
                "&car.generation=II" +
                "&car.modification=hatchback" +
                "&car.engine=diesel" +
                "&car.year=1989" +
                "&user.id=zero" +
                "&user.name=user" +
                "&user.phoneNumber=1234" +
                "&customer.id=zero" +
                "&customer.name=bob" +
                "&customer.city=minsk" +
                "&customer.phoneNumber=923429823" +
                "&customer.email=1823rew@mail.com" +
                "&id=zero" +
                "&orderStatus=new" +
                "&user=Vasyl" +
                "&car=vag");
        orderController.doCommand(request, response);
        assertEquals("Order 1 is created", response.getResponse());
        request = new Request("get order -d id=234532");
        orderController.doCommand(request, response);
        assertEquals("Error 404: Order with 234532 not found", response.getResponse());
    }
}
