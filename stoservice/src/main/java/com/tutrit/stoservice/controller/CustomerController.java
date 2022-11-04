package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.service.CustomerService;
import com.tutrit.stoservice.utils.GetId;

import static com.tutrit.stoservice.utils.GetCustomer.getCustomer;

public class CustomerController implements CommandController {

    public static final Command command = Command.NEW_CUSTOMER;

    CustomerService customerService;

    GetId getId;


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
        switch (request.getCommand()) {
            case "new customer" -> {
                customerService.saveCustomer(customer);
                response.setResponse("Customer " + customer.getId() + "is saved");
            }
            case "get customer" ->{
                customerService.getCustomer(getId.toString());
                response.setResponse("Customer find");
            }
        }
    }
}
