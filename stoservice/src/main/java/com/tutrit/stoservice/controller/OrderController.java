package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.service.OrderService;

import static com.tutrit.stoservice.utils.UserInputToOrder.getOrder;

public class OrderController implements CommandController {
    private static final Command command = Command.NEW_ORDER;

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void doCommand(Request request, Response response) {
        Order order = getOrder(request.getCommand());
        if (order != null) {
            orderService.saveOrder(order);
            response.setResponse("Order " + order.getId() + " is created");
            return;
        }
        response.setResponse("Order not created");
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
