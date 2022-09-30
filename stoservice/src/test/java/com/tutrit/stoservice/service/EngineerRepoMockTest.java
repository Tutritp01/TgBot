package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;

public class EngineerRepoMockTest extends EngineerRepository {
    @Override
    public Engineer save(Engineer engineer) {
        System.out.println("Done!");
        return null;
    }
}
