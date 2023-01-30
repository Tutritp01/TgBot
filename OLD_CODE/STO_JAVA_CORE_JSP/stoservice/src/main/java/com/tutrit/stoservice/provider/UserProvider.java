package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.User;

import java.util.ArrayList;
import java.util.List;

public class UserProvider {

    private UserProvider() {
        throw new IllegalStateException("Utility class");
    }

    public static List<User> getUsers() {
        List<User> initialUsers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = getInstance(i);
            initialUsers.add(user);
        }
        return initialUsers;
    }

    public static List<User> getUsers(int amount) {
        List<User> initialUsers = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            User user = getInstance(i);
            initialUsers.add(user);
        }
        return initialUsers;
    }

    static User getInstance(int i) {
        return new User("Id" + i, "User" + i, "Phone" + i);
    }

    static User getInstance() {
        return new User("Id", "User", "Phone");
    }
}
