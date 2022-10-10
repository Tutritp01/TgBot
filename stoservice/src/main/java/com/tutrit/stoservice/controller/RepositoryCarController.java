package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.service.CarService;

public class RepositoryCarController implements CommandController {

    private static final Command command = Command.SAVE_CAR;

    @Override
    public Command getCommand() {
        return command;
    }

    public void doCommand(Request request, Response response) {
        CarService.saveCarToRep(request);
        response.setResponse("car saved");
    }
}
