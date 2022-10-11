package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.Repository;

public class EngineerService {
    Repository repository;

    public EngineerService(final Repository repositoryIn) {
        this.repository = repositoryIn;
    }

    public void save(Engineer engineer) {
        repository.save(engineer);
    }
}
