package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.mock.UserRepositoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private UserService userService;

    @BeforeAll
    public static void load() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    public void setUp() {
        userService = ApplicationContext.get(UserService.class);
        userService.setUserRepository(new UserRepositoryMock());
    }

    @Test
    void saveUser() {
        User user = userService.saveUser(new User("id1", "user1", "123"));
        Assertions.assertEquals(makeUser(), user);
    }

    private User makeUser() {
        return new User("id1", "user1", "123");
    }
}
