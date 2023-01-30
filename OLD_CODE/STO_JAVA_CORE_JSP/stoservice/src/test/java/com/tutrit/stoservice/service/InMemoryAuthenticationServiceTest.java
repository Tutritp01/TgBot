package com.tutrit.stoservice.service;

import com.tutrit.stoservice.context.ApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryAuthenticationServiceTest {

    InMemoryAuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        authenticationService = ApplicationContext.get(InMemoryAuthenticationService.class);
    }

    @Test
    @DisplayName("Should return true when the username and password are correct")
    void loginWhenUsernameAndPasswordAreCorrectThenReturnTrue() {

        boolean result = authenticationService.login("admin", "1234");

        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when the password is incorrect")
    void loginWhenPasswordIsIncorrectThenReturnFalse() {

        boolean result = authenticationService.login("admin", "123");

        assertFalse(result);
    }

    @Test
    @DisplayName("Should return false when the username is incorrect")
    void loginWhenUsernameIsIncorrectThenReturnFalse() {

        boolean result = authenticationService.login("administrator", "1234");

        assertFalse(result);
    }
}
