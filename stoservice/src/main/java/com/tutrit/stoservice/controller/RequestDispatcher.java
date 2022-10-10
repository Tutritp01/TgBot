package com.tutrit.stoservice.controller;


import com.tutrit.stoservice.repository.EngineerRepository;
import com.tutrit.stoservice.service.EngineerService;
import com.tutrit.stoservice.util.InputCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.tutrit.stoservice.util.InputCommand.inputMsg;

public class RequestDispatcher {

    public static Logger logger = LoggerFactory.getLogger("Dispatcher");

    public void doDispatch(String userInput) {
        Request request = new Request(userInput);
        Response response = new Response();

        Map map = inputMsg(userInput);

        switch (Command.fromString(map.get("command").toString())) {
            case SHOW_DATA -> new DataController().doCommand(map, response);
            case EXIT -> new ExitController().doCommand(map, response);
            case NOT_A_COMMAND -> new NotACommandController().doCommand(map, response);
            case HELP -> new HelpController().doCommand(map, response);
            case NEW_ENGINEER -> new EngineerController(new EngineerService(new EngineerRepository())).doCommand(map, response);
        }
        logger.info(response.getResponse());
    }
}
