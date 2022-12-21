package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CustomerRepository;

public class CustomerRepositoryUUIDMock extends CustomerRepository {

    @Override
    public void setUUID(Customer customer) {
        customer.setId("spyValues" + count());

    }
}
