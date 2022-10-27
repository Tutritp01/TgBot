package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.repository.UserRepository;

public class UserRepositoryMock extends UserRepository {
    @Override
    public User save(User user) {
        return new User("id1", "user1", "123");
    }

    @Override
    public void saveAll(Iterable<User> users) {
    }

    @Override
    public User find(User user) {
        return null;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
