package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CustomerRepository;

public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
