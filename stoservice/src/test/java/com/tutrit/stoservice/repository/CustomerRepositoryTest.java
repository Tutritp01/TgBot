package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.mock.CustomerRepositoryUUIDMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomerRepositoryTest {

    CustomerRepository customerRepository;

    @BeforeEach
    void SetUp() {
        customerRepository = new CustomerRepositoryUUIDMock();

    }

    @Test
    void saveCustomer() {
        customerRepository.save(new Customer("1", "customer1", "city1", "phoneNumber1", "email1"));
        assertEquals(1, customerRepository.count());

        Customer customer = new Customer("2", "customer2", "city2", "phoneNumber2", "email2");
        customerRepository.save(customer);
        System.out.println(customerRepository);
        assertEquals(customerRepository.findById("spyValues2"), customerRepository.find(customer));
    }

    @Test
    void saveAll() {
        int expected = customerRepository.count() + 7;
        customerRepository.saveAll((List.of(
                new Customer("1", "customer1", "city1", "phoneNumber1", "email1"),
                new Customer("2", "customer2", "city2", "phoneNumber2", "email2"),
                new Customer("6", "customer3", "city3", "phoneNumber3", "email3"),
                new Customer("7", "customer4", "city4", "phoneNumber4", "email4"),
                new Customer("5", "customer5", "city5", "phoneNumber5", "email5"),
                new Customer("7", "customer6", "city6", "phoneNumber6", "email6"),
                new Customer("7", "customer7", "city7", "phoneNumber7", "email7")
        )));

        assertEquals(expected, customerRepository.count());
    }

    @Test
    void findCustomer() {
        Customer customer = new Customer("3", "customer3", "city3", "phoneNumber3", "email3");
        customerRepository.save(customer);
        customerRepository.find(customer);
        assertEquals("spyValues3", customerRepository.find(customer).getId());
    }

    @Test
    void findAll() throws IllegalAccessException, NoSuchFieldException {
        Class<CustomerRepository> customerRepositoryClass = CustomerRepository.class;
        Field customers = customerRepositoryClass.getDeclaredField("customers");
        customers.setAccessible(true);
        Set<Customer> myCustomers = (Set<Customer>) customers.get(customerRepositoryClass);

        assertEquals(myCustomers, customerRepository.findAll());
    }

    @Test
    void findCustomerById() {
        Customer cus1 = new Customer("6", "customer3", "city3", "phoneNumber3", "email3");
        Customer cus2 = new Customer("7", "customer4", "city4", "phoneNumber4", "email4");
        Customer customerId = new Customer("spyValues1", "customer6", "city6", "phoneNumber6", "email6");
        customerRepository.save(cus2);
        customerRepository.save(cus1);
        customerRepository.findById(customerId.getId());
        assertEquals("spyValues1", customerRepository.findById(customerId.getId()).getId());
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer("id7", "customer7", "city7", "phoneNumber7", "email7");
        customerRepository.update(customer);
        assertEquals(customer, customerRepository.update(customer));
    }

    @Test
    void deleteCustomer() {
        Customer customer = new Customer("spyValues8", "customer5", "city5", "phoneNumber5", "email5");
        customerRepository.delete(customer);
        assertEquals(0, customerRepository.count());
    }

    @Test
    void deleteById() {
        Customer customerId = new Customer("9876", "customer5", "city5", "phoneNumber5", "email5");
        customerRepository.deleteById(customerId.getId());
        assertFalse(customerRepository.deleteById(customerId.getId()));
    }

    @Test
    void count() {
        assertEquals(0, customerRepository.count());
    }
}
