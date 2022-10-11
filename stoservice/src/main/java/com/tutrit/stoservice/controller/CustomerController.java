package com.tutrit.stoservice.controller;

public class CustomerController implements CommandController {


    private static final Command command = Command.SAVE_NEW_CUSTOMER;
    public void doCommand(Request request, Response response) {
        response.setResponse(String.format("save new customer", request.getCommand()));
    }

    @Override
    public Command getCommand() {
        return command;
    }

}
