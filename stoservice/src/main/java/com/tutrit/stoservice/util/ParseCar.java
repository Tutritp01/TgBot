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

    public static Car parseCommand(Request request) throws ArrayIndexOutOfBoundsException{
        var car = new Car();
        String userInput = request.getCommand();
        String[] parseMap = userInput.split("-d");
        parseMap[0] = parseMap[0].strip();
        parseMap[1] = parseMap[1].strip();

        Map<String, String> carInformation = stringToMapParser(parseMap[1]);
        car.setId(UUID.randomUUID().toString());
        for (int i = 0; i < carInformation.size(); i++) {
            switch (i) {
                case 0 -> car.setBrand(carInformation.get("brand"));
                case 1 -> car.setModel(carInformation.get("model"));
                case 2 -> car.setGeneration(carInformation.get("generation"));
                case 3 -> car.setModification(carInformation.get("modification"));
                case 4 -> car.setEngine(carInformation.get("engine"));
                case 5 -> car.setYear(Integer.parseInt(carInformation.get("year")));
                default -> logger.info("No vehicle data has been saved.");
            }
        }
        return car;
    }

    private static Map<String, String> stringToMapParser(String toParse) {
        return getStringStringMap(toParse);
    }
}
