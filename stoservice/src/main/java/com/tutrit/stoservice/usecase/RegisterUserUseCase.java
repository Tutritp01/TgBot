package com.tutrit.stoservice.usecase;

import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.bean.User;

import java.util.UUID;

public class RegisterUserUseCase {

    UserService userService;

    public RegisterUserUseCase(final UserService userService) {
        this.userService = userService;
    }

    public void run(String name, String phoneNumber) {
        User user = new User(UUID.randomUUID().toString(), name, phoneNumber);
        userService.saveUser(user);
    }
}
