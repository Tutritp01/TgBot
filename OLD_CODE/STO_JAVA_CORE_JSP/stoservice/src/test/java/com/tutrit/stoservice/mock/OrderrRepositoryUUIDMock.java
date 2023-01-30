package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;

public class OrderrRepositoryUUIDMock extends OrderRepository {

    @Override
    public void setUUID(Order order) {
        order.setId("spyValues" + count());

    }
}
