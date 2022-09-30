package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.service.UserService;

public class UserController implements CommandController {

    private static final Command command = Command.REGISTER_NEW_USER;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doCommand(Request request, Response response) {
        User user = new User("id1", "name1", "123-45-67");
        userService.saveUser(user);
        response.setResponse("new user has been saved");
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
