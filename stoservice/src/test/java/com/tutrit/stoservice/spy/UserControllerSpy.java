package com.tutrit.stoservice.spy;

import com.tutrit.stoservice.controller.Command;
import com.tutrit.stoservice.controller.Request;
import com.tutrit.stoservice.controller.Response;
import com.tutrit.stoservice.controller.UserController;
import com.tutrit.stoservice.service.UserService;

public class UserControllerSpy extends UserController {

    public int numSaveUserToRep = 0;

    public UserControllerSpy(UserService userService) {
        super(userService);
    }

    @Override
    public void doCommand(Request request, Response response) {
        numSaveUserToRep++;
        super.doCommand(request, response);
    }

    @Override
    public Command getCommand() {
        return super.getCommand();
    }
}
