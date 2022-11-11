package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUSerById(String id) {
        return userRepository.findById(id);
    }


    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}