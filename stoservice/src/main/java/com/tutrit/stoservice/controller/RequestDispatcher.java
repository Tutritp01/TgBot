package com.tutrit.stoservice.controller;


import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.repository.EngineerRepository;
import com.tutrit.stoservice.service.EngineerService;
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
            case NEW_ENGINEER -> ApplicationContext.get(EngineerController.class).doCommand(request, response);

        }
        logger.info(response.getResponse());
    }
}
