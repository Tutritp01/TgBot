package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.Repository;

public class CreateEngineerService {
    Repository repository;

    public CreateEngineerService(final Repository repositoryIn) {
        this.repository = repositoryIn;
    }

    public void create(Engineer engineer) {
        repository.save(engineer);
    }
}
