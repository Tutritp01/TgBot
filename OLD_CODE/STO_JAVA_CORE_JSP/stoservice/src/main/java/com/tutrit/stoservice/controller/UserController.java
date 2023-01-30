package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.bean.Promo;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.mapper.UserInput;
import com.tutrit.stoservice.service.MessageService;
import com.tutrit.stoservice.service.PromoService;
import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.util.GetBodyAsMap;
import com.tutrit.stoservice.util.ParseMessage;
import com.tutrit.stoservice.util.ParsePromo;
import com.tutrit.stoservice.util.ParseUser;
import com.tutrit.stoservice.utils.GetCommand;
import com.tutrit.stoservice.utils.GetIdFromMap;
import com.tutrit.stoservice.utils.GetMap;


public class UserController implements CommandController {

    private Command command;
    private final UserService userService;
    private final MessageService messageService;
    private final PromoService promoService;

    public UserController(UserService userService, MessageService messageService, PromoService promoService) {
        this.userService = userService;
        this.messageService = messageService;
        this.promoService = promoService;
    }

    @Override
    public void doCommand(Request request, Response response) {
        switch (GetCommand.getCommand(request.getCommand())) {
            case "new user" -> newUser(request, response);
            case "get user" -> getUserById(request, response);
            case "register" -> register(request, response);
            case "new event" -> newEvent(request, response);
            case "promo" -> promo(request, response);
            case "start promo" -> startPromo(request, response);
            default -> response.setResponse("Something went wrong");
        }
    }

    @Override
    public Command getCommand() {
        return command;
    }

    private void startPromo(Request request, Response response) {
        Promo promo = promoService.findPromo(ParsePromo.getArray(request)[0]);
        Message message = messageService.findMessage(ParsePromo.getArray(request)[1]);
        message = messageService.updateMessage(message, promo);
        response.setResponse(String.format("%nHi!!! a promo condition: %s", message.getEventText()));
    }

    private void promo(Request request, Response response) {
        User newUser = userService.saveUser(ParseUser.parseCommand(request));
        Promo promo = promoService.savePromo(ParsePromo.parseCommand(request, newUser));
        response.setResponse("\nDear " + newUser.getName() + "! you created a promo: \n" + promo.toString());
    }

    private void newEvent(Request request, Response response) {
        User newUser = userService.saveUser(ParseUser.parseCommand(request));
        messageService.saveMessage(ParseMessage.parseCommand(request, newUser));
        response.setResponse("new user and massage has been saved");
    }

    private void register(Request request, Response response) {
        userService.saveUserWithDiscount(ParseUser.parseCommand(request));
        response.setResponse("new user has been saved and got a 5% discount!");
    }

    private void newUser(Request request, Response response) {
        command = Command.REGISTER_NEW_USER;
        try {
            User user = newUserInput(request).getBodyAs(User.class);
            if (user != null) {
                userService.saveUser(user);
                response.setResponse("User " + user.getId() + " is created");
                return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.setResponse("User not created");
    }

    private void getUserById(Request request, Response response) {
        command = Command.GET_USER;
        String id = GetIdFromMap.getId(newUserInput(request).getObjectValues());
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

    private UserInput newUserInput(Request request) {
        UserInput userInput = new UserInput();
        userInput.setObjectValues(GetBodyAsMap.parseUserInput(request));
        return userInput;
    }
}
