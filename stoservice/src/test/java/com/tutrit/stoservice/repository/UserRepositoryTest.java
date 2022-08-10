package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void SetUp() {
        userRepository = new UserRepository();
        UserRepository.userMap.put("4", new User("4", "user4", "phone4"));
    }

    @Test
    void createUser() {
        userRepository.createUser("5", new User("5", "Boba", "141235"));
        assertEquals(1, UserRepository.userMap.size());

    }

}