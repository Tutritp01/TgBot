package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.Repository;

public class EngineerService {
    Repository<Engineer, String> repository;

    public EngineerService(final Repository<Engineer, String> repository) {
        this.repository = repository;
    }

    public void save(Engineer engineer) {
        repository.save(engineer);
    }
}
