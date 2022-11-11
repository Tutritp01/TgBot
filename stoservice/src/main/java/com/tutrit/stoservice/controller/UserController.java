package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.util.ParseUser;
import com.tutrit.stoservice.utils.GetCommand;
import com.tutrit.stoservice.utils.GetIdFromMap;
import com.tutrit.stoservice.utils.GetMap;

import static com.tutrit.stoservice.mapper.MapToUser.getUser;
import static com.tutrit.stoservice.utils.UserInputToEngineer.getEngineer;

public class UserController implements CommandController {

    private Command command;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doCommand(Request request, Response response) {
        switch (GetCommand.getCommand(request.getCommand())) {
            case "new user" -> newUser(request, response);
            case "get user" -> getUserById(request, response);
            default -> response.setResponse("Failure occurred, command not recognized");
        }
    }

    private void newUser(Request request, Response response) {
        command = Command.REGISTER_NEW_USER;
        User user = getUser(request.getCommand());
        if (user != null) {
            userService.saveUser(ParseUser.parseCommand(request));
            response.setResponse("User " + user.getId() + " is created");
            return;
        }
        response.setResponse("User not created");
    }

    private void getUserById(Request request, Response response) {
        command = Command.GET_USER;
        String id = GetIdFromMap.getId(GetMap.getMap(request.getCommand()));
        if (id != null) {
            User user = userService.findUSerById(id);
            if (user != null) {
                response.setResponse("User with ID: " + user.getId() + " found");
            } else {
                response.setResponse("Error 404: user with " + id + " not found");
            }
            return;
        }
        response.setResponse("Incorrectly entered command, failed to find the ID");
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
