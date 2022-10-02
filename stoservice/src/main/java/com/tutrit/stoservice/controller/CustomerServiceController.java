package com.tutrit.stoservice.controller;

public class CustomerServiceController {
    public void doCommand(Request request, Response response) {

        response.setResponse(String.format("create a new customer", request.getCommand()));
    }
}
