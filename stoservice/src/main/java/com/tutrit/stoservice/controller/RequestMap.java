package com.tutrit.stoservice.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMap extends Request {
    Map<String, String> commandMap = new HashMap<>();

    public RequestMap(String command) {
        super(command);
    }

    public RequestMap(Map<String, String> commandMap, String command) {
        this(command);
        this.commandMap = commandMap;
    }

    public void setCommandMap(Map commandMap) {
        this.commandMap = commandMap;
    }

    public Map getCommandMap() {
        return commandMap;
    }
}
