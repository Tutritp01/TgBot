package com.tutrit.stoservice.controller;


import com.tutrit.stoservice.parser.UserInputParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class RequestDispatcher {

    public static final Logger logger = LoggerFactory.getLogger("Dispatcher");

    public void doDispatch(String userInput) {
        Request request = new Request(userInput);
        Response response = new Response();
        request.setUserInput(UserInputParser.parseUserInput(request.getCommand()));

        switch (request.getUserInput().getCommand()) {
            case SHOW_DATA -> new DataController().doCommand(request, response);
            case EXIT -> new ExitController().doCommand(request, response);
            case NOT_A_COMMAND -> new NotACommandController().doCommand(request, response);
            case HELP -> new HelpController().doCommand(request, response);
            case REGISTER_NEW_USER -> get(UserController.class).doCommand(request, response);
        }
        logger.info(response.getResponse());
    }
}
