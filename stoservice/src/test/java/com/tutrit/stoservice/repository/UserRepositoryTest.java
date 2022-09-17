package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        UserRepository.userMap.put("1", new User("1", "user1", "phone1"));
        UserRepository.userMap.put("2", new User("2", "user2", "phone2"));
        UserRepository.userMap.put("3", new User("3", "user3", "phone3"));
        UserRepository.userMap.put("4", new User("4", "user4", "phone4"));
    }

    @AfterEach
    void tearDown() {
        UserRepository.userMap = new HashMap<>();
    }

    @Test
    void createUser() {
        userRepository.save(new User("5", "user5", "phone5"));
        assertEquals(5, UserRepository.userMap.size());
        assertTrue(UserRepository.userMap.containsKey("5"));
    }

    @Test
    void findUser() {
        User user = userRepository.save(new User("6", "user6", "phone6"));
        userRepository.find(user);
        assertEquals(5, UserRepository.userMap.size());
    }

    @Test
    void findUserById() {
        User expected = userRepository.save(new User("7", "user7", "phone 7"));
        User actual = userRepository.findById("7");
        assertEquals(expected, actual);
    }

    @Test
    void updateUser() {
        userRepository.update(new User("2", "name6", "phone6"));
        assertTrue(UserRepository.userMap.containsKey("2"));
    }

    @Test
    void deleteUserById() {
        userRepository.deleteById("3");
        assertEquals(3, UserRepository.userMap.size());
        assertFalse(UserRepository.userMap.containsKey("3"));
    }

    @Test
    void deleteUser() {
        User user = userRepository.save(new User("9", "user9", "phone9"));
        userRepository.delete(user);
        assertEquals(4, UserRepository.userMap.size());
        assertFalse(UserRepository.userMap.containsKey("9"));
    }
}
