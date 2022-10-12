package com.tutrit.stoservice.util;

public class GetCommand {
    public static String getCommand(String inputMsg) {
        if (inputMsg.indexOf('-') > 0) {
            return inputMsg.substring(0, inputMsg.indexOf('-')).trim();
        } else {
            return inputMsg.trim();
        }
    }
}
