package com.tutrit.stoservice.parser;

import com.tutrit.stoservice.controller.Command;

import java.util.Map;

public class UserInput {

    private Command command;
    private Map<String, String> objectValues;

    public Command getCommand() {
        return null;
    }

    public <T> T getBodyAs(Class<T> clazz) {
        return null;
    }

    public void setCommand(final Command command) {
        this.command = command;
    }

    public Map<String, String> getObjectValues() {
        return objectValues;
    }

    public void setObjectValues(final Map<String, String> objectValues) {
        this.objectValues = objectValues;
    }
}
