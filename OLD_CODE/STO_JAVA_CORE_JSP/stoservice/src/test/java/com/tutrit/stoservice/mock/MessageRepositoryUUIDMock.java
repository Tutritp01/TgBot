package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.repository.CustomerRepository;
import com.tutrit.stoservice.repository.MessageRepository;

public class MessageRepositoryUUIDMock extends MessageRepository {

    @Override
    public void setUUID(Message message) {
        message.setId("spyValues" + count());

    }
}
