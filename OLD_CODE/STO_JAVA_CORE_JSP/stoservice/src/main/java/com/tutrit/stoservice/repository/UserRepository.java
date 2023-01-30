package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepository implements Repository<User, String>, MyIdGenerator<User> {

    private static Map<String, User> userMap = new HashMap<>();

    @Override
    public User save(User user) {
        setUUID(user);
        userMap.put(user.getId(), user);

        return user;
    }

    @Override
    public void saveAll(Iterable<User> users) {
        for (User user : users) {
            setUUID(user);
            userMap.put(user.getId(), user);
        }
    }

    @Override
    public User find(User user) {
        return userMap.get(user.getId());
    }

    @Override
    public Iterable<User> findAll() {
        return userMap.values();
    }

    @Override
    public User findById(String id) {
        return userMap.get(id);
    }

    @Override
    public User update(User user) {
        userMap.replace(user.getId(), user);
        return user;
    }

    @Override
    public boolean delete(User user) {
        return userMap.remove(user.getId(), user);
    }

    @Override
    public boolean deleteById(String id) {
        return userMap.remove(id, userMap.get(id));
    }

    public int count() {
        return userMap.size();
    }

    @Override
    public void setUUID(User user) {
        user.setId(UUID.randomUUID().toString());

    }
}
