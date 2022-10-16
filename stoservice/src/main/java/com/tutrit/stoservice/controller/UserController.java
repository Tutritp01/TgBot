package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.parser.UserInput;
import com.tutrit.stoservice.parser.UserInputParser;
import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.util.ParseUser;

public class UserController implements CommandController {

    private static final Command command = Command.REGISTER_NEW_USER;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doCommand(Request request, Response response) {
        User user = request.getUserInput().getBodyAs(User.class);
        userService.saveUser(user);
        response.setResponse("new user has been saved");
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
