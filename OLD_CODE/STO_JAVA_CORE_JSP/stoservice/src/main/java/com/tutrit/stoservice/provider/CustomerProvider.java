package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerProvider {

    public Set<Customer> getCustomers(int i) {
        Set<Customer> result = new HashSet<>();
        for (int k = 0; k < i; k++) {
            result.add(getInstance(k));
        }
        return result;
    }

    private Customer getInstance(int i) {
        return new Customer("id" + i, "name" + i, "city" + i, "phoneNumber" + i, "email" + i);
    }
}
