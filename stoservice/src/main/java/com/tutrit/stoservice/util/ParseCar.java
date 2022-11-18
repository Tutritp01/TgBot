package com.tutrit.stoservice.util;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.controller.Request;

import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import static com.tutrit.stoservice.util.ParseMessage.getStringStringMap;

public class ParseCar {
    private static final Logger logger = Logger.getLogger(ParseCar.class.getName());

    private ParseCar() {
        throw new IllegalStateException("Utility class");
    }

    public static Car parseCommand(Request request) throws ArrayIndexOutOfBoundsException {
        var car = new Car();
        String userInput = request.getCommand();
        String[] parseMap = userInput.split("-d");
        parseMap[0] = parseMap[0].strip();
        parseMap[1] = parseMap[1].strip();

        Map<String, String> carInformation = stringToMapParser(parseMap[1]);
        car.setId(UUID.randomUUID().toString());
        car.setOwner(carInformation.get("owner"));
        car.setVin(carInformation.get("vin"));
        car.setPlateNumber(carInformation.get("plateNumber"));
        car.setBrand(carInformation.get("brand"));
        car.setModel(carInformation.get("model"));
        car.setGeneration(carInformation.get("generation"));
        car.setModification(carInformation.get("modification"));
        car.setEngine(carInformation.get("engine"));
        car.setYear(Integer.parseInt(carInformation.get("year")));
        if (carInformation.isEmpty()) logger.info("No vehicle data has been saved.");
        return car;
    }

    private static Map<String, String> stringToMapParser(String toParse) {
        return getStringStringMap(toParse);
    }
}
