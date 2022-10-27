package com.tutrit.stoservice.spy;

import com.tutrit.stoservice.controller.CarController;
import com.tutrit.stoservice.controller.Command;
import com.tutrit.stoservice.controller.Request;
import com.tutrit.stoservice.controller.Response;
import com.tutrit.stoservice.service.CarService;

public class CarControllerSpy extends CarController {


    public int numSaveCarToRep = 0;

    public CarControllerSpy(CarService carService) {
        super(carService);
    }

    @Override
    public void doCommand(Request request, Response response) {
        numSaveCarToRep++;
        super.doCommand(request, response);
    }

    @Override
    public Command getCommand() {
        return super.getCommand();
    }
}
