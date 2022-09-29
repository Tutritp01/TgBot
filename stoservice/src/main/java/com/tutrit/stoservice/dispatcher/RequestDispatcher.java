package com.tutrit.stoservice.dispatcher;


import com.tutrit.stoservice.controller.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestDispatcher {

    public static Logger logger = LoggerFactory.getLogger("Dispatcher");

    public void doDispatch(String userInput) {
        Request request = new Request(userInput);
        Response response = new Response();

        switch (Command.fromString(request.getCommand())) {
            case SHOW_DATA -> new DataController().doCommand(request, response);
            case EXIT -> new ExitController().doCommand(request, response);
            case NOT_A_COMMAND -> new NotACommandController().doCommand(request, response);
            case HELP -> new HelpController().doCommand(request, response);

        }
        logger.info(response.getResponse());
    }
}
