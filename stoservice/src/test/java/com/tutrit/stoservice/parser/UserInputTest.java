package com.tutrit.stoservice.parser;

import com.tutrit.stoservice.bean.Car;
import org.junit.jupiter.api.Test;

import java.util.Map;

class UserInputTest {

    @Test
    void getBodyAs() throws Exception{
        Map<String, String> values = Map.of(
                "brand", "tesla",
                "model", "X",
                "generation", "I",
                "modification", "suv",
                "engine", "diesel",
                "year", "2008",
                "user.name", "User name",
                "user.phoneNumber", "1234 1234- 34123"
        );
        UserInput userInput = new UserInput();
        userInput.setObjectValues(values);

        Car car = userInput.getBodyAs(Car.class);
        System.out.println(car);

    }
}