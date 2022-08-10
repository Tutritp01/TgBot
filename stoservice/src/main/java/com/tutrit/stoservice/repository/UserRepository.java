package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    public static Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public static Map<String, User> userMap = new HashMap<>();

    public void createUser(String id, User user) {
        userMap.put(id, user);
    }
}
