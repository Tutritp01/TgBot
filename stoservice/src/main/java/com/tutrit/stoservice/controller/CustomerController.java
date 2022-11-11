package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.service.CustomerService;
import com.tutrit.stoservice.utils.GetIdFromMap;
import com.tutrit.stoservice.utils.GetMap;

import static com.tutrit.stoservice.utils.GetCustomer.getCustomer;

public class CustomerController implements CommandController {

    private Command command;
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Command getCommand() {
        return command;

    }

    @Override
    public void doCommand(Request request, Response response) {
        Customer customer = getCustomer(request.getCommand());
        switch (request.getCommand()) {
            case "new customer" -> newCustomer(request, response);
            case "get customer" -> getCustomerById(request, response);
        }
    }

    private void newCustomer(Request request, Response response) {
        command = Command.NEW_CUSTOMER;
        Customer customer = getCustomer(request.getCommand());
        if (customer != null) {
            customerService.saveCustomer(customer);
            response.setResponse("Customer " + customer.getId() + "is saved");
            return;
        }
        response.setResponse("Customer not created");
    }

    private void getCustomerById(Request request, Response response) {
        command = Command.GET_CUSTOMER;
        String id = GetIdFromMap.getId(GetMap.getMap(request.getCommand()));
        if (id != null) {
            Customer customer = customerService.getCustomer(id);
            if (customer != null) {
                response.setResponse("Customer with ID: " + customer.getId() + " found");
            } else {
                response.setResponse("Error 404: customer with " + id + " not found");
            }
            return;
        }
        response.setResponse("Incorrectly entered command, failed to find the ID");
    }
}
