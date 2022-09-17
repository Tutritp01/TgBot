package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    CustomerRepository customerRepository;

    @BeforeEach
    void SetUp() {
        customerRepository = new CustomerRepository();
        CustomerRepository.customers.addAll(List.of(
                new Customer("1", "customer1", "city1", "phoneNumber1", "email1"),
                new Customer("2", "customer2", "city2", "phoneNumber2", "email2"),
                new Customer("3", "customer3", "city3", "phoneNumber3", "email3"),
                new Customer("4", "customer4", "city4", "phoneNumber4", "email4"),
                new Customer("5", "customer5", "city5", "phoneNumber5", "email5"),
                new Customer("6", "customer6", "city6", "phoneNumber6", "email6"),
                new Customer("7", "customer7", "city7", "phoneNumber7", "email7")
        ));


    }

    @Test
    void saveCustomer() {
        customerRepository.save(new Customer("3", "customer3", "city3", "phoneNumber3", "email3"));
        assertEquals(7, CustomerRepository.customers.size());

        customerRepository.save(new Customer("8", "customer8", "city8", "phoneNumber8", "email8"));
        assertTrue(CustomerRepository.customers.contains(new Customer("8", "customer8", "city8", "phoneNumber8", "email8")));
        CustomerRepository.customers.clear();
    }

    @Test
    void saveAll() {
        CustomerRepository.customers.addAll((List.of(
                new Customer("1", "customer1", "city1", "phoneNumber1", "email1"),
                new Customer("2", "customer2", "city2", "phoneNumber2", "email2"),
                new Customer("6", "customer3", "city3", "phoneNumber3", "email3"),
                new Customer("7", "customer4", "city4", "phoneNumber4", "email4"),
                new Customer("5", "customer5", "city5", "phoneNumber5", "email5"),
                new Customer("7", "customer6", "city6", "phoneNumber6", "email6"),
                new Customer("7", "customer7", "city7", "phoneNumber7", "email7")
        )));
        assertEquals(10, CustomerRepository.customers.size());



    }

    @Test
    void findCustomer() {
        Customer customer = new Customer("6", "customer6", "city6", "phoneNumber6", "email6");
        customerRepository.find(customer);
        assertEquals(customer, customerRepository.find(customer));


    }

    @Test
    void findAll() {
        customerRepository.findAll();
        assertEquals(CustomerRepository.customers, customerRepository.findAll());
    }

    @Test
    void findCustomerById() {
        Customer customerId = new Customer("7", "customer7", "city7", "phoneNumber7", "email7");
        customerRepository.findById(customerId.getId());
        assertEquals(customerId,customerRepository.findById(customerId.getId()));



    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer("7", "customer7", "city7", "phoneNumber7", "email7");
        customerRepository.update(customer);
        assertEquals(true, CustomerRepository.customers.contains(customer));

    }

    @Test
    void deleteCustomer() {
        Customer customer = new Customer("5", "customer5", "city5", "phoneNumber5", "email5");
        customerRepository.delete(customer);
        assertEquals(6, CustomerRepository.customers.size());
    }

    @Test
    void deleteById() {
        Customer customerId = new Customer("9876", "customer5", "city5", "phoneNumber5", "email5");
        customerRepository.deleteById (customerId.getId());
        assertEquals(false,customerRepository.deleteById (customerId.getId()));

    }



    @Test
    void count() {
        assertEquals(7, customerRepository.count());
    }



}
