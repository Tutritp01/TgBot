package com.tutrit.stoservice.utility;

import java.util.ArrayList;
import java.util.List;

public class ParseCommand {

    static String command;
    static String body;
    static String input;

    public static String setUserInput(String userInput) {
        input = userInput;
        return userInput;
    }

    public static List<String> parseCommand(String Input) {
        String[] parseByFlags = Input.split("-data");
        List<String> parseFlags = new ArrayList<>();
        if (parseByFlags.length > 1) {
            parseFlags.add(parseByFlags[0].trim());
            parseFlags.add(parseByFlags[1].trim());
        } else {
            parseFlags.add(parseByFlags[0].trim());
            parseFlags.add(null);

        }
        return parseFlags;
    }


    public static String getCommand(String userInput) {
        setUserInput(userInput);
        List<String> parsUserInput = parseCommand(input);
        command = parsUserInput.get(0);
        body = parsUserInput.get(1);
        return command;
    }

    public String getBody() {
        return body;
    }
}
