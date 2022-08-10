package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {


    public static Map<String, User> userMap = new HashMap<>();

    public void createUser(String id, User user) {
        userMap.put(id, user);
    }

    public User findUser(String id) {
        return userMap.get(id);
    }

    public User updateUser(String id, User user) {
        return userMap.replace(id, user);
    }

    public User deleteUser(String id) {
        return userMap.remove(id);
    }
}
