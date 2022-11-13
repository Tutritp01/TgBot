package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.bean.Promo;
import com.tutrit.stoservice.service.MessageService;
import com.tutrit.stoservice.service.PromoService;
import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.util.ParseMessage;
import com.tutrit.stoservice.util.ParsePromo;
import com.tutrit.stoservice.util.ParseUser;
import com.tutrit.stoservice.utils.GetCommand;
import com.tutrit.stoservice.utils.GetIdFromMap;
import com.tutrit.stoservice.utils.GetMap;
import static com.tutrit.stoservice.mapper.MapToUser.getUser;
import static com.tutrit.stoservice.utils.UserInputToEngineer.getEngineer;


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
            case "register" -> {
                userService.saveUserWithDiscount(ParseUser.parseCommand(request));
                response.setResponse("new user has been saved and got a 5% discount!");
            }

            case "new event" -> {
                User newUser = userService.saveUser(ParseUser.parseCommand(request));
                messageService.saveMessage(ParseMessage.parseCommand(request, newUser));
                response.setResponse("new user and massage has been saved");
            }
            case "promo" -> {
                User newUser = userService.saveUser(ParseUser.parseCommand(request));
                Promo promo = promoService.savePromo(ParsePromo.parseCommand(request, newUser));
                response.setResponse("\nDear " + newUser.getName() + "! you created a promo: \n" + promo.toString());
            }
            case "start promo" -> {
                Promo promo = promoService.findPromo(ParsePromo.getArray(request)[0]);
                Message message = messageService.findMessage(ParsePromo.getArray(request)[1]);
                message = messageService.updateMessage(message, promo);
                response.setResponse(String.format("%nHi!!! a promo condition: %s", message.getEventText()));
            }
            default -> response.setResponse("Something went wrong");
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
