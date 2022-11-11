package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.service.MessageService;
import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.util.ParseMessage;
import com.tutrit.stoservice.util.ParseUser;
import com.tutrit.stoservice.utils.GetCommand;

public class UserController implements CommandController {

    private static final Command command = Command.REGISTER_NEW_USER;
    private final UserService userService;
    private final MessageService messageService;

    public UserController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }
    
    @Override
    public void doCommand(Request request, Response response) {

        switch (GetCommand.getCommand(request.getCommand())) {
            case "register" -> {
                userService.saveUserWithDiscount(ParseUser.parseCommand(request));
                response.setResponse("new user has been saved and got a 5% discount!");
            }
            case "new_user" -> {
                userService.saveUser(ParseUser.parseCommand(request));
                response.setResponse("new user has been saved");
            }
            case "new event" -> {
                userService.saveUser(ParseUser.parseCommand(request));
                messageService.saveMessage(ParseMessage.parseCommand(request, newUser));
                response.setResponse("new user and massage has been saved");
            }
            default -> response.setResponse("Something went wrong");
       }
    }

    @Override
    public Command getCommand() {
        return command;
    }
}
