package com.tutrit.persistence;

import com.tutrit.service.UUIDWrapper;

public class UUIDWrapperMock extends UUIDWrapper {
    private int count;

    @Override
    public String getID() {
        return Integer.toString(count++);
    }
}
