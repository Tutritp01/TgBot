package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userRepository.save(new User("1", "user1", "phone1"));
        userRepository.save(new User("2", "user2", "phone2"));
        userRepository.save(new User("3", "user3", "phone3"));
        userRepository.save(new User("4", "user4", "phone4"));
    }

    @Test
    void createUser() {
        int expectedCount = userRepository.count() + 1;
        userRepository.save(new User("5", "user5", "phone5"));
        assertEquals(expectedCount, userRepository.count());
    }

    @Test
    void findUser() {
        int expectedCount = userRepository.count() + 1;
        User user = userRepository.save(new User("6", "user6", "phone6"));
        User expected = userRepository.find(user);
        assertEquals(expectedCount, userRepository.count());
        assertEquals(expected, userRepository.find(user));
    }

    @Test
    void findUserById() {
        User expected = userRepository.save(new User("7", "user7", "phone 7"));
        User actual = userRepository.findById("7");
        assertEquals(expected, actual);
    }

    @Test
    void updateUser() {
        User expected = userRepository.update(new User("2", "name6", "phone6"));
        assertEquals(expected, userRepository.findById("2"));
    }

    @Test
    void deleteUserById() {
        int expectedCount = userRepository.count() - 1;
        assertTrue(userRepository.deleteById("3"));
        assertEquals(expectedCount, userRepository.count());
    }

    @Test
    void deleteUser() {
        int expectedCount = userRepository.count() + 1;
        User user = userRepository.save(new User("9", "user9", "phone9"));
        assertFalse(userRepository.delete(user));
        assertEquals(expectedCount, userRepository.count());
    }
}
