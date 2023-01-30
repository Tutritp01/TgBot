package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CustomerRepository;

public class CustomerRepositoryMock extends CustomerRepository {


    @Override
    public Customer save(Customer customer) {
        return null;
    }


}
