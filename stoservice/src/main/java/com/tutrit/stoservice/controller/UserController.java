package com.tutrit.stoservice.controller;


import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.bean.Promo;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.service.MessageService;
import com.tutrit.stoservice.service.PromoService;
import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.util.ParseMessage;
import com.tutrit.stoservice.util.ParsePromo;
import com.tutrit.stoservice.util.ParseUser;
import com.tutrit.stoservice.utils.GetCommand;

public class UserController implements CommandController {

    private static final Command command = Command.REGISTER_NEW_USER;
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
            case "register" -> {
                userService.saveUserWithDiscount(ParseUser.parseCommand(request));
                response.setResponse("new user has been saved and got a 5% discount!");
            }
            case "new_user" -> {
                userService.saveUser(ParseUser.parseCommand(request));
                response.setResponse("new user has been saved");
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

    @Override
    public Command getCommand() {
        return command;
    }
}
