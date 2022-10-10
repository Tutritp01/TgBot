package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.service.EngineerService;

import java.util.HashMap;
import java.util.Map;

public class EngineerController implements CommandController{
    EngineerService engineerService;
    public static final Command command = Command.NEW_ENGINEER;

    EngineerController(EngineerService engineerService){
        this.engineerService = engineerService;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public void doCommand(Map request, Response response) {
        String object = request.get("object").toString();
        Map<String, String> map = new HashMap<>();

        String[] flagAndArgs = object.split(" ");
        for (String block : flagAndArgs) {
            String[] temp = block.split(":");
            map.put(temp[0], temp[1]);
        }
        Engineer engineer = new Engineer(
                "temp",
                map.get("LN"),
                map.get("FN"),
                map.get("Fun"),
                map.get("Cat"),
                map.get("Edu"),
                Integer.parseInt(map.get("Exp")),
                Integer.parseInt(map.get("GExp"))
        );

        engineerService.save(engineer);
        response.setResponse("Engineer " + engineer.getIdEngineer() + " is created");
    }
}
