package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerProviderTest {

    CustomerProvider customerProvider;

    @BeforeEach
    void setUp() {
        customerProvider = new CustomerProvider();
    }

    @Test
    void getCustomers() {
        Set<Customer> customerSet = new HashSet<>();

        customerSet.add(new Customer("id0", "name0", "city0", "phoneNumber0", "email0"));
        customerSet.add(new Customer("id1", "name1", "city1", "phoneNumber1", "email1"));
        customerSet.add(new Customer("id2", "name2", "city2", "phoneNumber2", "email2"));
        customerSet.add(new Customer("id3", "name3", "city3", "phoneNumber3", "email3"));
        customerSet.add(new Customer("id4", "name4", "city4", "phoneNumber4", "email4"));

        assertEquals(customerSet, customerProvider.getCustomers(5));
        assertEquals(5, customerProvider.getCustomers(5).size());
    }
}
