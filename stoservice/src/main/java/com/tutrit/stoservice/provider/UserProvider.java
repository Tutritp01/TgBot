package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.User;

import java.util.HashMap;
import java.util.Map;

public class UserProvider {

    static Map<String, Object> getUsers() {
        Map<String, Object> initialUsers = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            User user = getInstance(i);
            initialUsers.put(user.getId(), user);
        }
        return initialUsers;
    }

    static Map<String, Object> getUsers(int amount) {
        Map<String, Object> initialUsers = new HashMap<>();
        for (int i = 0; i < amount; i++) {
            User user = getInstance(i);
            initialUsers.put(user.getId(), user);
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
