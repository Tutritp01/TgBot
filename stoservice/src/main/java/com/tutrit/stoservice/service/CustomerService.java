package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CustomerRepository;

public class CustomerService {

   private static CustomerRepository customerRepository;

    public CustomerService(final CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
