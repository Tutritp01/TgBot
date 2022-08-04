package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashSet;


public class CustomerRepository {

    public static Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    public static HashSet<Customer> customers = new HashSet<>();

    public Customer createCustomer(Customer customer) {
        if (customers.isEmpty() != true)
            if (customers.contains(customer) == false) {
                customers.add(new Customer());
            } else {
                logger.info("Customers already exists");

            }

        return customer;
    }

    public Customer findCustomer(Customer customer) {
        if (customers.contains(customer) == true) {
            return customer;
        } else {
            logger.warn("Customer does not exist");
        }
        return customer;
    }

    public Customer findCustomerById(String id) {
        return null;
    }

    public Customer updateCustomer(Customer customer) {
        if (customers.contains(customer) == true)
            logger.info("This customers exists");
        else
            createCustomer(customer);
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

