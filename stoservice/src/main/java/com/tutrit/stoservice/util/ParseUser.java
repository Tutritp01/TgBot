package com.tutrit.stoservice.util;

import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.controller.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseUser {

    private ParseUser() {
        throw new IllegalStateException("Utility class");
    }

    public static User parseCommand(Request request) {

        var user = new User();

        List<Integer> positions = new ArrayList<>();
        int i = 0;
        while (i != -1) {
            int index = request.getCommand().indexOf("-", i);
            if (index != -1) {
                positions.add(index);
                i = index + 1;
            } else {
                i = index;
            }
        }

        Map<String, String> parameters = new HashMap<>();
        for (int k = 0; k < positions.size(); k++) {
            int pos = positions.get(k);
            if (k == positions.size() - 1) {
                parameters.put(
                        request.getCommand().substring(pos + 1, pos + 2),
                        request.getCommand().substring(pos + 3));
            } else {
                parameters.put(
                        request.getCommand().substring(pos + 1, pos + 2),
                        request.getCommand().substring(pos + 3, positions.get(k + 1) - 1));
            }
        }

        user.setId(parameters.get("i"));
        user.setName(parameters.get("n"));
        user.setPhoneNumber(parameters.get("p"));

        return user;
    }
}
