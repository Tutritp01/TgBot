package com.tutrit.stoservice.mapper;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.utils.GetMap;

import java.util.Map;

public class MapToUser {

    public static User getUser(String inputMsg) {
        Map<String, String> map = GetMap.getMap(inputMsg);
        return makeUser(map);
    }

    private static User makeUser(Map<String, String> map) {
        var user = new User();
        if (!map.isEmpty()) {
            user.setName(map.get("name"));
            user.setPhoneNumber(map.get("phoneNumber"));
            return user;
        }
        return null;
    }
}
