package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        UserRepository.users.addAll(List.of(
                new User("id1", "name1"),
                new User("id2", "name2"),
                new User("id3", "name3"),
                new User("id4", "name4"),
                new User("id5", "name5")
                ));
    }

    @Test
    void createUser() {
    }

    @Test
    void findUser() {
    }

    @Test
    void findUserById() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void testDeleteUser() {
    }

    @Test
    void count() {
        assertEquals(5, userRepository.count());
    }
}