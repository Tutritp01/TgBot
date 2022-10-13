package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestDispatcherTest {
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    public static void init() {
        ApplicationContextLoader.run();
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void doDispatchRegisterNewUser() {
        String userInput = "new_user -data -i id1 -n user1 -p 123";
        RequestDispatcher requestDispatcher = ApplicationContext.get(RequestDispatcher.class);
        requestDispatcher.doDispatch(userInput);
        assertEquals("[main] INFO Dispatcher - new user has been saved\r\n", output.toString().substring(13));
    }
}
