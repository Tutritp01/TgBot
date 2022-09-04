package com.tutrit.stoservice.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void getCar() {
        Command.ofCommand("get car 1");
    }

}