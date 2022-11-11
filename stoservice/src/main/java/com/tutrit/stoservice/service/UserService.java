package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Promo;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.repository.PromoRepository;
import com.tutrit.stoservice.repository.UserRepository;

import java.time.LocalDateTime;

public class UserService {

    private UserRepository userRepository;
    private PromoRepository promoRepository = new PromoRepository();

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User saveUserWithDiscount(User user) {
        Promo promo = new Promo();
        promo.setDiscount(5);
        promo.setNamePromo(user.getName() + "-5%");
        promo.setAuthor(user);
        promo.setStartDate(LocalDateTime.now());
        promoRepository.save(promo);
        return userRepository.save(user);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
