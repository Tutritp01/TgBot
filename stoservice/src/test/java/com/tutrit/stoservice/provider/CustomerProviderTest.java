package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CustomerProviderTest {

    CustomerProvider customerProvider;

    @BeforeEach
    void setUp() {
        customerProvider = new CustomerProvider();
    }

    @Test
    void getCustomers() {
        Set<Customer> customerSet = new HashSet<>();

        customerSet.add(new Customer("id1", "name1", "city1", "phoneNumber1", "email1"));
        customerSet.add(new Customer("id2", "name2", "city2", "phoneNumber2", "email2"));
        customerSet.add(new Customer("id3", "name3", "city3", "phoneNumber3", "email3"));
        customerSet.add(new Customer("id4", "name4", "city4", "phoneNumber4", "email4"));
        customerSet.add(new Customer("id5", "name5", "city5", "phoneNumber5", "email5"));

        assertEquals(customerSet, customerProvider.getCustomers());
        assertEquals(5, customerProvider.getCustomers().size());
    }

    @Test
    void getInstance() {
        Customer customer1 = customerProvider.getInstance();
        Customer customer2 = customerProvider.getInstance();
        Customer customer3 = customerProvider.getInstance();

        assertEquals(customer1, customer2);

        customer3.setId("id1");
        assertNotEquals(customer1, customer3);
    }
}
