package com.tutrit.stoservice.service;

import java.util.Map;
import java.util.Objects;

public class InMemoryAuthenticationService {

    private static final Map<String, String> logins = Map.of("admin", "1234", "moderator", "qwer", "user", "asdf");

    public boolean login(String username, String password) {
        return Objects.equals(logins.get(username), password);
    }
}
