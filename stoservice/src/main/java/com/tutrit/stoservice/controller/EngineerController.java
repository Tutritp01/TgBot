package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.service.EngineerService;
import com.tutrit.stoservice.utils.GetCommand;

import static com.tutrit.stoservice.utils.UserInputToEngineer.getEngineer;

public class EngineerController implements CommandController {
    public static Command command;

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
            case "new engineer" -> {
                command = Command.NEW_ENGINEER;
                Engineer engineer = getEngineer(request.getCommand());
                if (engineer != null) {
                    engineerService.save(engineer);
                    response.setResponse("Engineer " + engineer.getIdEngineer() + " is created");
                    return;
                }
                response.setResponse("Engineer not created");
            }
            case "get engineer id" -> {
                command = Command.GET_ENGINEER_ID;
                String id = getID(request.getCommand());
                engineerService.findById(request.getCommand);
            }
        }
    }
}
