package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.repository.UserRepository;

public class UserService {

    UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.createUser(user);
    }
}
