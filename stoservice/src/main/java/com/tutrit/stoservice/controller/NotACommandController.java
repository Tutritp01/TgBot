package com.tutrit.stoservice.controller;

public class NotACommandController {

    public void doCommand(Request request,Response response){
              response.setResponse(String.format("print 'help' to see list of available commands",request.getCommand()));
       }


    }

