package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.service.CustomerService;

import static com.tutrit.stoservice.utils.GetCustomer.getCustomer;

public class CustomerController implements CommandController {

    public static final Command command = Command.NEW_CUSTOMER;

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public  void doCommand(Request request, Response response) {
        Customer customer = getCustomer(request.getCommand());
        customerService.saveCustomer(customer);
        response.setResponse("Customer " + customer.getId() + "is saved");

    }

}
