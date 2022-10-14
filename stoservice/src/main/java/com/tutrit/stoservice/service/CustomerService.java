package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.repository.CustomerRepository;

import java.util.UUID;


import static com.tutrit.stoservice.service.ParseBody.parseBody;

public class CustomerService {
    public static void saveCustomer(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        customer.setName(parseBody().get("n"));
        customer.setCity(parseBody().get("c"));
        customer.setPhoneNumber(parseBody().get("p"));
        customer.setEmail(parseBody().get("e"));
        ApplicationContext.get(CustomerRepository.class).save(customer);
    }
}
