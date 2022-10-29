package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserProviderTest {

    List<User> initialUsers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        initialUsers.add(new User("Id0", "User0", "Phone0"));
        initialUsers.add(new User("Id1", "User1", "Phone1"));
        initialUsers.add(new User("Id2", "User2", "Phone2"));
        initialUsers.add(new User("Id3", "User3", "Phone3"));
        initialUsers.add(new User("Id4", "User4", "Phone4"));
        initialUsers.add(new User("Id5", "User5", "Phone5"));
        initialUsers.add(new User("Id6", "User6", "Phone6"));
        initialUsers.add(new User("Id7", "User7", "Phone7"));
        initialUsers.add(new User("Id8", "User8", "Phone8"));
        initialUsers.add(new User("Id9", "User9", "Phone9"));
    }

    @Test
    void getUsers() {
        assertEquals(initialUsers, UserProvider.getUsers());
    }

    @Test
    void getUsersWithIncrement() {
        assertEquals(initialUsers, UserProvider.getUsers(10));
    }

    @Test
    void getInstanceWithNumber() {
        int i = 2;
        assertEquals(new User("Id" + i, "User" + i, "Phone" + i), UserProvider.getInstance(i));
    }

    @Test
    void getInstance() {
        assertEquals(new User("Id", "User", "Phone"), UserProvider.getInstance());
    }
}
