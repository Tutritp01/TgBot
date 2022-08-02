package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepository {

    public static Set<Customer> customers = new HashSet<>();

    public Customer createCustomer(Customer customer) {
        return null;
    }

    public Customer findCustomer(Customer customer) {
        return null;
    }

    public Customer findCustomerById(String id) {
        return null;
    }

    public Customer updateCustomer(Customer customer) {
        return null;
    }

    public boolean deleteCustomer(Customer customer) {
        return false;
    }

    public boolean deleteCustomer(String id) {
        return false;
    }

    public int count(){
        return customers.size();
    }


}
