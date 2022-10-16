package com.tutrit.stoservice.parser;

import com.tutrit.stoservice.context.ApplicationContext;

public class ProtocolProvider {

    BodyProtocol getProtocol(String input) {
        if (input.contains(" -d ") && input.contains(" -json ")) {
            return ApplicationContext.get(JsonBodyProtocol.class);
        } else if (input.contains(" -d ") && !input.contains(" -json ")) {
            return ApplicationContext.get(MapBodyProtocol.class);
        }
        return i -> {
            throw new RuntimeException("Not supported protocol");
        };
    }
}
