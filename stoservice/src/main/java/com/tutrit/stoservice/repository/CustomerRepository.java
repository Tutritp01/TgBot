package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepository {
            public static Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
        public static HashSet<Customer> customers = new HashSet<>();

        public Customer createCustomer(Customer customer) {
            if (customers.contains(customer) == false) {
                customers.add(customer);
            } else {
                logger.info("Customers already exists");
            }
            return customer;
        }

        public Customer findCustomer(Customer customer) {
            for (final Customer cus : customers) {
                if (cus.equals(customer)) {
                    return cus;
                }
            }
            return null;
        }

        public Customer findCustomerById(String id) {
            for (final Customer customer : customers) {
                if (customer.getId().equals(id)) {
                    return customer;
                }
            }
            return null;
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
            for (final Customer customer : customers) {
                if (customer.getId().equals(id)) {
                    customers.remove(customer);
                    return true;
                }
            }
            return false;
        }

        public int count() {
            return customers.size();
        }

    }


