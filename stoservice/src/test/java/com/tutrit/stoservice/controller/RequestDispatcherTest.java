package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RequestDispatcherTest {

    @BeforeAll
    public static void init() {
        ApplicationContextLoader.run();
    }

    @Test
    void doDispatchRegisterNewUser() {
        String userInput = "new_user";
        RequestDispatcher requestDispatcher = ApplicationContext.get(RequestDispatcher.class);
        requestDispatcher.doDispatch(userInput);
    }
}