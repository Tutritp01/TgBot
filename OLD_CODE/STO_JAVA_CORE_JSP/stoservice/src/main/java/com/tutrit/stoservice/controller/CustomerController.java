package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.mapper.UserInput;
import com.tutrit.stoservice.service.CustomerService;
import com.tutrit.stoservice.util.GetBodyAsMap;
import com.tutrit.stoservice.utils.GetCommand;
import com.tutrit.stoservice.utils.GetIdFromMap;

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
        switch (GetCommand.getCommand(request.getCommand())) {
            case "new customer" -> newCustomer(request, response);
            case "get customer" -> getCustomerById(request, response);
            default -> response.setResponse("Failure occurred, command not recognized");
        }
    }

    private void newCustomer(Request request, Response response) {
        command = Command.NEW_CUSTOMER;
        try {
            Customer customer = newUserInput(request).getBodyAs(Customer.class);
            if (customer != null) {
                customerService.saveCustomer(customer);
                response.setResponse("Customer " + customer.getId() + "is saved");
                return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.setResponse("Customer not created");
    }

    private void getCustomerById(Request request, Response response) {
        command = Command.GET_CUSTOMER;
        String id = GetIdFromMap.getId(newUserInput(request).getObjectValues());
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

    private UserInput newUserInput(Request request) {
        UserInput userInput = new UserInput();
        userInput.setObjectValues(GetBodyAsMap.parseUserInput(request));
        return userInput;
    }
}
