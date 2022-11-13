package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.service.EngineerService;
import com.tutrit.stoservice.utils.GetCommand;
import com.tutrit.stoservice.utils.GetIdFromMap;
import com.tutrit.stoservice.utils.GetMap;

import static com.tutrit.stoservice.utils.UserInputToEngineer.getEngineer;

public class EngineerController implements CommandController {
    private Command command;

    EngineerService engineerService;

    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public void doCommand(Request request, Response response) {
        switch (GetCommand.getCommand(request.getCommand())) {
            case "new engineer" -> newEngineer(request, response);
            case "get engineer" -> getEngineerId(request, response);
            default -> response.setResponse("Failure occurred, command not recognized");
        }
    }

    private void newEngineer(Request request, Response response) {
        command = Command.NEW_ENGINEER;
        Engineer engineer = getEngineer(request.getCommand());
        if (engineer != null) {
            engineerService.saveEngineer(engineer);
            response.setResponse("Engineer " + engineer.getIdEngineer() + " is created");
            return;
        }
        response.setResponse("Engineer not created");
    }

    private void getEngineerId(Request request, Response response) {
        command = Command.GET_ENGINEER;
        String id = GetIdFromMap.getId(GetMap.getMap(request.getCommand()));
        if (id != null) {
            Engineer engineer = engineerService.findById(id);
            if (engineer != null) {
                response.setResponse("Engineer with ID: " + engineer.getIdEngineer() + " found");
            } else {
                response.setResponse("Error 404: Engineer with " + id + " not found");
            }
            return;
        }
        response.setResponse("Incorrectly entered command, failed to find the ID");
    }
}
