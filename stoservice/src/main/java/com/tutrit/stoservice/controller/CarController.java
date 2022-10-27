package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.service.CarService;

public class CarController implements CommandController {

    private static final Command command = Command.SAVE_CAR;
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    public void doCommand(Request request, Response response) {
        carService.saveCar(request);
        response.setResponse("new car has been saved");
    }
}
