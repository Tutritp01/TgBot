package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void createCustomer() {
        customerRepository.createCustomer(new Customer("3", "customer3", "city3", "phoneNumber3", "email3"));
        assertEquals(7, CustomerRepository.customers.size());

        customerRepository.createCustomer(new Customer("8", "customer8", "city8", "phoneNumber8", "email8"));
        assertEquals(8, CustomerRepository.customers.size());
    }


    @Test
    void findCustomer() {
        Customer customer = new Customer("6", "customer6", "city6", "phoneNumber6", "email6");
        customerRepository.findCustomer(customer);
        assertEquals(7, CustomerRepository.customers.size());


    }

    @Test
    void findCustomerById() {

    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer("7", "customer7", "city7", "phoneNumber7", "email7");
        customerRepository.updateCustomer(customer);
        assertEquals(true,CustomerRepository.customers.contains(customer));

    }

    @Test
    void deleteCustomer() {
        Customer customer = new Customer("5", "customer5", "city5", "phoneNumber5", "email5");
        customerRepository.deleteCustomer(customer);
        assertEquals(6, CustomerRepository.customers.size());
    }


    @Test
    void testDeleteCustomer() {


    }

    @Test
    void count() {
        assertEquals(7, customerRepository.count());
    }
}
