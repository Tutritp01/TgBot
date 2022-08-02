package com.tutrit.tgbot.example.repository;

import com.tutrit.tgbot.example.bean.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {


    @Test
    void createCustomer() {

        Customer customer = new Customer();
        CustomerRepository customerRepository = new CustomerRepository();
        Customer result = customerRepository.createCustomer(customer);
        assertEquals(customer, result);
        assertEquals(1, customerRepository.count());
    }

    @Test
    void findCustomer() {
        Customer customer= new Customer();
        CustomerRepository customerRepository = new CustomerRepository();
        Customer result = customerRepository.findCustomer(customer);
        assertEquals(customer, result);

    }
}