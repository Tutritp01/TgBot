package com.tutrit.stoservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class RequestDispatcher {

    public static Logger logger = LoggerFactory.getLogger("Dispatcher");

    public void doDispatch(String userInput) {
        Request request = new Request(userInput);
        Response response = new Response();

        switch (Command.fromString(getCommand(userInput))) {
            case SHOW_DATA -> new DataController().doCommand(request, response);
            case EXIT -> new ExitController().doCommand(request, response);
            case NOT_A_COMMAND -> new NotACommandController().doCommand(request, response);
            case HELP -> new HelpController().doCommand(request, response);
            case SAVE_CAR -> get(CarController.class).doCommand(request,response);
        }
        logger.info(response.getResponse());
    }
}
