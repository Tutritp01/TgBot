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
            case SHOW_DATA -> get(DataController.class).doCommand(request, response);
            case EXIT -> get(ExitController.class).doCommand(request, response);
            case NOT_A_COMMAND ->get(NotACommandController.class).doCommand(request, response);
            case HELP -> get(HelpController.class).doCommand(request, response);
            case NEW_CUSTOMER -> (get(CustomerController.class)).doCommand(request, response);
            case REGISTER_NEW_USER, REGISTER, NEW_EVENT -> get(UserController.class).doCommand(request, response);
            case SAVE_CAR -> get(CarController.class).doCommand(request,response);
            case NEW_ENGINEER, GET_ENGINEER -> get(EngineerController.class).doCommand(request, response);
            case NEW_ORDER, GET_ORDER -> get(OrderController.class).doCommand(request, response);
            default -> response.setResponse("Error, command not recognized");
        }
        logger.info(response.getResponse());
    }
}
