package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.service.CustomerService;

public class CustomerController implements CommandController {


    private static final Command command = Command.SAVE_NEW_CUSTOMER;
    public void doCommand(Request request, Response response) {
        CustomerService.saveCustomer(new Customer());
        response.setResponse("save new customer");
    }

    @Override
    public Command getCommand() {
        return command;
    }

}
