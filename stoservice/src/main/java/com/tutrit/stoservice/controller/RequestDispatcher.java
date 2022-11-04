package com.tutrit.stoservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static com.tutrit.stoservice.utils.GetCommand.getCommand;


public class RequestDispatcher {

    public static final Logger logger = LoggerFactory.getLogger("Dispatcher");


    public void doDispatch(String userInput) {
        Request request = new Request(userInput);
        Response response = new Response();


        switch (Command.fromString(getCommand(userInput))) {
            case SHOW_DATA -> new DataController().doCommand(request, response);
            case EXIT -> new ExitController().doCommand(request, response);
            case NOT_A_COMMAND -> new NotACommandController().doCommand(request, response);
            case HELP -> new HelpController().doCommand(request, response);
            case NEW_CUSTOMER, GET_CUSTOMER -> (get(CustomerController.class)).doCommand(request, response);
            case REGISTER_NEW_USER -> get(UserController.class).doCommand(request, response);
            case SAVE_CAR -> get(CarController.class).doCommand(request,response);
            case NEW_ENGINEER -> get(EngineerController.class).doCommand(request, response);
        }
        logger.info(response.getResponse());
    }
}
