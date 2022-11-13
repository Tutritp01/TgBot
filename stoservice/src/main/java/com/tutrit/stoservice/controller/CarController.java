package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.service.CarService;
import com.tutrit.stoservice.util.ParseCar;
import com.tutrit.stoservice.utils.GetCommand;
import com.tutrit.stoservice.utils.GetIdFromMap;
import com.tutrit.stoservice.utils.GetMap;

public class CarController implements CommandController {

    private Command command;
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    public void doCommand(Request request, Response response) {

        switch (GetCommand.getCommand(request.getCommand())) {
            case "save car" -> newCar(request, response);
            case "get car" -> getCarById(request, response);
            default -> response.setResponse("Failure occurred, command not recognized");
        }
    }

    private void newCar(Request request, Response response) {
        command = Command.SAVE_CAR;
        try {
            Car car = ParseCar.parseCommand(request);
            carService.saveCar(car);
            response.setResponse("Car " + car.getId() + " is saved");
        } catch (Exception e) {
            response.setResponse("Car not saved");
        }
    }

    private void getCarById(Request request, Response response) {
        command = Command.GET_CAR;
        String id = GetIdFromMap.getId(GetMap.getMap(request.getCommand()));
        if (id != null) {
            Car car = carService.getCar(id);
            if (car != null) {
                response.setResponse(car.toString());
            } else {
                response.setResponse("Error 404: car with " + id + " not found");
            }
            return;
        }
        response.setResponse("Incorrectly entered command, failed to find the ID");
    }
}
