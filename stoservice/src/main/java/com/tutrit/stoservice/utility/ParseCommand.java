package com.tutrit.stoservice.utility;

import java.util.ArrayList;
import java.util.List;


public class ParseCommand {

    private String command;
    private String body;

    public List<String> parseCommand(String userInput) {
        String[] parseByFlags = userInput.split("-data");
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

    public String getCommand(String userInput) {
        List<String> parsUserInput = parseCommand(userInput);
        this.command = parsUserInput.get(0);
        this.body = parsUserInput.get(1);
        return command;
    }

    public String getBody() {
        return body;
    }
}
