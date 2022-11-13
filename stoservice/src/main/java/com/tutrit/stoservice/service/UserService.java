package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.repository.PromoRepository;
import com.tutrit.stoservice.repository.UserRepository;
import com.tutrit.stoservice.util.ParsePromo;

public class UserService {

    private UserRepository userRepository;
    private PromoRepository promoRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User saveUserWithDiscount(User user) {
        promoRepository.save(ParsePromo.defaultPromo(user));
        return userRepository.save(user);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
