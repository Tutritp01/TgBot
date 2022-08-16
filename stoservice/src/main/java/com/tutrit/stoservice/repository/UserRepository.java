package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {


    public static Map<String, User> userMap = new HashMap<>();

    public User createUser(String id, User user) {
        return userMap.put(id, user);
    }

    public User findUser(User user) {
        return null;
    }

    public User findUserById(String id) {
        return userMap.get(id);
    }

    public User updateUser(String id, User user) {
        return userMap.replace(id, user);
    }

    public User deleteUserById(String id) {
        return userMap.remove(id);
    }

    public boolean deleteUser(User user, String id) {
        return userMap.remove(id, user);
    }

    public int count() {
        return userMap.size();
    }
}
