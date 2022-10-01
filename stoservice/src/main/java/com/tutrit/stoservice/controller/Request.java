package com.tutrit.stoservice.controller;

import java.util.ArrayList;
import java.util.List;

public class Request {
    private String command;
    private List<String> information = new ArrayList<>();

    public Request(String inputString) {
        String[] inputData = inputString.split(" ");
        command = inputData[0];
        for (int i = 1; i < inputData.length; i++) {
            information.add(inputData[i]);
        }
    }

    public List<String> getInformation() {
        return information;
    }

    public void setInformation(List<String> information) {
        this.information = information;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
