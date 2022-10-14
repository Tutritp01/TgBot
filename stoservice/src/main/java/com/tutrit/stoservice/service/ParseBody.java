package com.tutrit.stoservice.service;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.utility.ParseCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseBody {
    public static Map<String, String> parseBody() {
        List<Integer> positions = new ArrayList<>();
        String body = ApplicationContext.get(ParseCommand.class).getBody();
        int i = 0;
        while (i != -1) {
            Integer index = body.indexOf("-", i);
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
                        body.substring(pos + 1, pos + 2),
                        body.substring(pos + 3));
            } else {
                parameters.put(
                        body.substring(pos + 1, pos + 2),
                        body.substring(pos + 3, positions.get(k + 1) - 1));
            }
        }
        return parameters;
    }
}
