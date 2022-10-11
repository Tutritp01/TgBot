package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.util.InputStringToMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static com.tutrit.stoservice.util.InputStringToMap.inputMsg;

public class RequestDispatcher {

    public static Logger logger = LoggerFactory.getLogger("Dispatcher");

    public void doDispatch(String userInput) {
        Request request = new Request(userInput);
        Response response = new Response();
        RequestMap requestMap = new RequestMap(InputStringToMap.inputMsg(userInput), userInput);

        switch (Command.fromString(requestMap.getCommandMap().get("command").toString())) {
            case SHOW_DATA -> new DataController().doCommand(request, response);
            case EXIT -> new ExitController().doCommand(request, response);
            case NOT_A_COMMAND -> new NotACommandController().doCommand(request, response);
            case HELP -> new HelpController().doCommand(request, response);
            case NEW_ENGINEER -> get(EngineerController.class).doCommand(request, response);
        }
        logger.info(response.getResponse());
    }
}
