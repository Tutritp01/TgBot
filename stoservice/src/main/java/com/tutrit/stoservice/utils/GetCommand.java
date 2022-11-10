package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.controller.Request;

public class GetCommand {
    public static String getCommand(String inputMsg) {
        if (inputMsg.contains("-")) {
            return inputMsg.substring(0, inputMsg.indexOf('-')).strip();
        } else {
            return inputMsg.strip();
        }
    }

    public static String getCommandFromRequest(Request request) {
        String userInput = request.getCommand();
        String[] parseMap = userInput.split("-");
        return parseMap[0].strip();
    }
    private GetCommand() {
        throw new IllegalStateException("Utility class");
    }
}
