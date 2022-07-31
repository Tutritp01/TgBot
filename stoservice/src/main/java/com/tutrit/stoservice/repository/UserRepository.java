package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> users = new ArrayList<>();

    public User createUser(User user) {
        return null;
    }

    public User findUser(User user) {
        return null;
    }

    public User findUserById(String id) {
        return null;
    }

    public User updateUser(User user) {
        return null;
    }

    public boolean deleteUser(User user) {
        return false;
    }

    public boolean deleteUser(String id) {
        return false;
    }

    public int count() {
        return users.size();
    }
}
