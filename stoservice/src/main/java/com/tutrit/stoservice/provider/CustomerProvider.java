package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerProvider {

    public Set<Customer> getCustomers() {
        Set<Customer> result = new HashSet<>();
        Customer initial = getInstance();

        for (int i = 1; i <= 5; i++) {
            result.add(new Customer(initial.getId().concat(String.valueOf(i)),
                    initial.getName().concat(String.valueOf(i)),
                    initial.getCity().concat(String.valueOf(i)),
                    initial.getPhoneNumber().concat(String.valueOf(i)),
                    initial.getEmail().concat(String.valueOf(i))));
        }
        return result;
    }

    public Customer getInstance() {
        return new Customer("id", "name", "city", "phoneNumber", "email");
    }
}
