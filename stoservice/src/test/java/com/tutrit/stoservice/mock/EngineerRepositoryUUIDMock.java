package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.CustomerRepository;
import com.tutrit.stoservice.repository.EngineerRepository;

public class EngineerRepositoryUUIDMock extends EngineerRepository {
    @Override
    public Engineer save(Engineer engineer) {
        return super.save(engineer);
    }

    @Override
    public void saveAll(Iterable<Engineer> engineersInput) {
        super.saveAll(engineersInput);
    }

    @Override
    public Engineer find(Engineer engineer) {
        return super.find(engineer);
    }

    @Override
    public Iterable<Engineer> findAll() {
        return super.findAll();
    }

    @Override
    public Engineer findById(String id) {
        return super.findById(id);
    }

    @Override
    public Engineer update(Engineer engineer) {
        return super.update(engineer);
    }

    @Override
    public boolean delete(Engineer engineer) {
        return super.delete(engineer);
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
    public void setUUID(Engineer engineer) {
        engineer.setId("spyValues" + count());

    }
}
