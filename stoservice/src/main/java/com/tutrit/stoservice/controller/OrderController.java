package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.service.OrderService;

public class OrderController implements CommandController {

    private static final Command command = Command.REGISTER_NEW_ORDER;
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public void doCommand(Request request, Response response) {
        Order order = new Order();
        orderService.saveOrder(order);
        response.setResponse("new user has been saved");
    }
}
