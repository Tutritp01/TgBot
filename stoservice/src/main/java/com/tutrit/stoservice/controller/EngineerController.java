package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.service.EngineerService;

public class EngineerController implements CommandController{
    public static final Command command = Command.NEW_ENGINEER;

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
        Engineer engineer = new Engineer();
        engineerService.save(engineer);
        response.setResponse("Engineer " + engineer.getIdEngineer() + " is created");
    }
}
