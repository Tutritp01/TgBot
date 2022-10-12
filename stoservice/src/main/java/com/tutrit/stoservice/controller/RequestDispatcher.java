package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.util.GetCommand;
import com.tutrit.stoservice.util.InputStringToMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static com.tutrit.stoservice.util.GetCommand.*;
import static com.tutrit.stoservice.util.InputStringToMap.inputMsg;

public class RequestDispatcher {

    public static Logger logger = LoggerFactory.getLogger("Dispatcher");

    public void doDispatch(String userInput) {
        Request request = new Request(userInput);
        Response response = new Response();

        switch (Command.fromString(getCommand(userInput))) {
            case SHOW_DATA -> get(DataController.class).doCommand(request, response);
            case EXIT -> get(ExitController.class).doCommand(request, response);
            case NOT_A_COMMAND -> get(NotACommandController.class).doCommand(request, response);
            case HELP -> get(HelpController.class).doCommand(request, response);
            case NEW_ENGINEER -> get(EngineerController.class).doCommand(request, response);
        }

        logger.info(response.getResponse());
    }
}
