package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.contex.ApplicationContext;
import com.tutrit.stoservice.contex.ApplicationContextLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestDispatcherTest {

    @BeforeAll
    public static void load() {
        ApplicationContextLoader.run();
    }

    @Test
    void doDispatchCreateNewUser() {
        String userInput = "new_user -n Mikas -ph Shelkovich";
        RequestDispatcher requestDispatcher = ApplicationContext.get(RequestDispatcher.class);
        requestDispatcher.doDispatch(userInput);
    }
}