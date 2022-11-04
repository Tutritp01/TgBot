package com.tutrit.stoservice.utils;

public class GetId {
    private  String getId(String inputMsg) {
        if (inputMsg.contains("-") && inputMsg.contains("-id")) {
           return inputMsg.substring(inputMsg.indexOf('-') + 1, inputMsg.indexOf("-id")).trim();

        }
        return "null";
    }

}
