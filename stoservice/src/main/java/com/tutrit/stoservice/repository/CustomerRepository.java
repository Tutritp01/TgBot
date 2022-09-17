package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.controller.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;

public class CustomerRepository implements Repository<Customer, String> {

    public static Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    public static HashSet<Customer> customers = new HashSet<>();

    @Override
    public Customer save(Customer customer) {
        if (customers.contains(customer) == false) {
            customers.add(customer);
        } else {
            logger.info("Customers already exists");
        }
        return customer;
    }

    @Override
    public void saveAll(Iterable<Customer> obj) {
       customers.addAll(new HashSet<>());

    }

    @Override
    public Customer find(Customer customer) {
        for (final Customer cus : customers) {
            if (cus.equals(customer)) {
                return cus;
            }
        }
        return null;
    }

    @Override
    public Iterable<Customer> findAll() {
        return customers;

    }

    @Override
    public Customer findById(String id) {
        for (final Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        if (customers.contains(customer) == true) {
            return customer;
        } else {
            delete(customer);
        }
        return customer;
    }

    @Override
    public boolean delete(Customer customer) {
        if (customers.contains(customer) == true) {
            customers.remove(customer);
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
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


