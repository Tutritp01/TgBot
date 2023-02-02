package com.tutrit.service;

import java.util.UUID;

public class UUIDWrapper {
    public String getID() {
        return UUID.randomUUID().toString();
    }
}
