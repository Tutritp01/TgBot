package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CustomerRepository;
import com.tutrit.stoservice.utils.GetId;

public class CustomerService {

   private static CustomerRepository customerRepository;


    public CustomerService(final CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void getCustomer (String id){
        customerRepository.findById(id);
    }
}
