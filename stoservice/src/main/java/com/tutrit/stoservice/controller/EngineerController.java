package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.service.EngineerService;

public class EngineerController implements CommandController{
    EngineerService engineerService;
    public static final Command command = Command.NEW_ENGINEER;

    EngineerController(EngineerService engineerService){
        this.engineerService = engineerService;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public void doCommand(Request request, Response response) {
        Engineer engineer = new Engineer("1"    , "Нестор", "Майко", "Инжинер по гарантии", "высшая", "высшее", 5, 10);
        engineerService.save(engineer);
        response.setResponse("Engineer " + engineer.getIdEngineer() + " is created");
    }
}
