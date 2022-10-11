package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.service.CustomerService;

public class CustomerController implements CommandController {


    private static final Command command = Command.SAVE_NEW_CUSTOMER;
    public void doCommand(Request request, Response response) {
        CustomerService.saveCustomer();
        response.setResponse(String.format("save new customer", request.getCommand()));
    }

    @Override
    public Command getCommand() {
        return command;
    }

}
