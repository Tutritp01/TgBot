package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CustomerRepository;

public class CustomerRepositoryUUIDMock extends CustomerRepository {
    @Override
    public Customer save(Customer customer) {
        return super.save(customer);
    }

    @Override
    public void saveAll(Iterable<Customer> obj) {
        super.saveAll(obj);
    }

    @Override
    public Customer find(Customer customer) {
        return super.find(customer);
    }

    @Override
    public Iterable<Customer> findAll() {
        return super.findAll();
    }

    @Override
    public Customer findById(String id) {
        return super.findById(id);
    }

    @Override
    public Customer update(Customer customer) {
        return super.update(customer);
    }

    @Override
    public boolean delete(Customer customer) {
        return super.delete(customer);
    }

    @Override
    public boolean deleteById(String id) {
        return super.deleteById(id);
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public void setUUID(Customer customer) {
        customer.setId("spyValues" + count());

    }
}
