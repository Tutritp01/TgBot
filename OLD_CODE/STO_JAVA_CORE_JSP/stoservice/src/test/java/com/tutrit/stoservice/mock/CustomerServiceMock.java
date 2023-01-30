package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CustomerRepository;
import com.tutrit.stoservice.service.CustomerService;

public class CustomerServiceMock extends CustomerService {



    public CustomerServiceMock(CustomerRepository customerRepository) {
        super(customerRepository);
    }

    @Override
    public void saveCustomer(Customer customer) {
        super.saveCustomer(customer);
    }

}



