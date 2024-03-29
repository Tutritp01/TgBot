package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.Repository;

public class EngineerService {
    Repository<Engineer, String> repository;

    public EngineerService(final Repository<Engineer, String> repository) {
        this.repository = repository;
    }

    public void saveEngineer(Engineer engineer) {
        repository.save(engineer);
    }

    public Engineer findById (String id) {
        return repository.findById(id);
    }
}
