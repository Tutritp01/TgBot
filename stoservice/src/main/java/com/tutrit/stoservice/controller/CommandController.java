package com.tutrit.stoservice.controller;

import java.util.Map;

public interface CommandController {
    Command getCommand();
    void doCommand(Map requestMap, Response response);
}
