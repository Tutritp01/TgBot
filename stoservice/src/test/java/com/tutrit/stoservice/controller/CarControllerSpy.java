package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.service.CarService;

public class CarControllerSpy extends CarController{


    public int numSaveCarToRep = 0;

    public CarControllerSpy(CarService carService) {
        super(carService);
    }

    @Override
    public void doCommand(Request request, Response response) {
        CarService.saveCar(request);
        super.doCommand(request, response);
        numSaveCarToRep++;
    }
}
