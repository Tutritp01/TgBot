package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashSet;
import java.util.Iterator;


public class CustomerRepository {

    public static Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    public static HashSet<Customer> customers = new HashSet<>();

    Iterator<Customer> iterationId = customers.iterator();

    public Customer createCustomer(Customer customer) {
        if (customers.contains(customer) == false) {
            customers.add(customer);
        } else {
            logger.info("Customers already exists");
        }
        return customer;
    }

    public Customer findCustomer(Customer customer) {
        if (customers.contains(customer) == true) {
            return customer;
        } else
            logger.info("Customer does not exist, create customer");
        createCustomer(customer);
        return customer;
    }

    public Customer findCustomerById(Customer id) {

        return id;
    }

    public Customer updateCustomer(Customer customer) {
        if (customers.contains(customer) == true) {
            return customer;
        } else {
            deleteCustomer(customer);
        }
        return customer;
    }

    public boolean deleteCustomer(Customer customer) {
        if (customers.contains(customer) == true) {
            customers.remove(customer);
        }
        return false;
    }

    public boolean deleteCustomer(String id) {
        return false;
    }

    public int count() {
        return customers.size();
    }


}

