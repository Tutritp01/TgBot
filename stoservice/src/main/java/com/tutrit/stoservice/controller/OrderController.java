package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.mapper.UserInput;
import com.tutrit.stoservice.service.OrderService;
import com.tutrit.stoservice.util.GetBodyAsMap;
import com.tutrit.stoservice.utils.GetCommand;
import com.tutrit.stoservice.utils.GetIdFromMap;
import com.tutrit.stoservice.utils.GetMap;

public class OrderController implements CommandController {
    Command command;
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void doCommand(Request request, Response response) {
        switch (GetCommand.getCommand(request.getCommand())) {
            case "new order" -> newOrder(request, response);
            case "get order" -> getOrderId(request, response);
            default -> response.setResponse("Failure occurred, command not recognized");
        }
    }

    @Override
    public Command getCommand() {
        return command;
    }

    private void newOrder(Request request, Response response) {
        command = Command.NEW_ORDER;
        try {
            Order order = newUserInput(request).getBodyAs(Order.class);
            if (order != null) {
                orderService.saveOrder(order);
                response.setResponse("Order " + order.getId() + " is created");
                return;
            }
            response.setResponse("Order not created");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void getOrderId(Request request, Response response) {
        command = Command.GET_ORDER;
        String id = GetIdFromMap.getId(newUserInput(request).getObjectValues());
        if (id != null) {
            Order order = orderService.findById(id);
            if (order != null) {
                response.setResponse("Order with ID: " + order.getId() + " found");
            } else {
                response.setResponse("Error 404: Order with " + id + " not found");
            }
            return;
        }
        response.setResponse("Incorrectly entered command, failed to find the ID");
    }

    private UserInput newUserInput(Request request) {
        UserInput userInput = new UserInput();
        userInput.setObjectValues(GetBodyAsMap.parseUserInput(request));
        return userInput;
    }
}
