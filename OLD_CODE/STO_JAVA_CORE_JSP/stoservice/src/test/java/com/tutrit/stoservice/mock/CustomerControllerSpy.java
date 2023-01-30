package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.controller.Command;
import com.tutrit.stoservice.controller.CustomerController;
import com.tutrit.stoservice.controller.Request;
import com.tutrit.stoservice.controller.Response;
import com.tutrit.stoservice.service.CustomerService;

public class CustomerControllerSpy extends CustomerController {
    public int numSaveCustomerToRepCalled = 0;

    @Override
    public Command getCommand() {
        return super.getCommand();
    }

    public CustomerControllerSpy(CustomerService customerService) {
        super(customerService);
    }

    @Override
    public void doCommand(Request request, Response response) {
        numSaveCustomerToRepCalled++;

    }
}
