package com.tutrit.stoservice.controller;

import static com.tutrit.stoservice.controller.Command.SHOW_DATA;
import static com.tutrit.stoservice.controller.Command.fromString;

public class RequestDispatcher {

    public void doDispatch (String userInput){
        Request request = new Request(userInput);
        Response response = new Response();

        switch (Command.fromString(request.getCommand())){
            case SHOW_DATA -> new DataController().doCommand(request,response);
            case EXIT -> new ExitController().doCommand(request,response);
            case NOT_A_COMMAND -> new NotACommandController().doCommand(request,response);

        }



    }
}

