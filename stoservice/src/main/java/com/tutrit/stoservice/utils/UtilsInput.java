package com.tutrit.stoservice.utils;

import java.util.*;
import java.util.stream.Collectors;

public class UtilsInput {
    private UtilsInput() {
    }

    public static List<String> parseFlags(String userInput) {
        String[] parseMap = userInput.split("-d");
        List<String> parseFlags = new ArrayList<>();
        if (parseMap.length > 1) {
            parseFlags.add(parseMap[0].strip());
            parseFlags.add(parseMap[1].strip());
        } else {
            parseFlags.add(parseMap[0].strip());
            parseFlags.add(null);
        }
        return parseFlags;
    }

    public static Map<String, String> stringToMapParser(String toParse) {
        try {
            final String[] keysAndValues = toParse.split("&");
            return Arrays.stream(keysAndValues)
                    .collect(Collectors.toMap(
                            a -> a.substring(0, a.indexOf("=")),
                            b -> b.substring(b.indexOf("=") + 1)
                    ));
        }catch (NullPointerException e){
            return Collections.emptyMap();
        }
    }
}
