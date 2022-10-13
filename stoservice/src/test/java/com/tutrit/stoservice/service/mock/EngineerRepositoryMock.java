package com.tutrit.stoservice.service.mock;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;

public class EngineerRepositoryMock extends EngineerRepository {

    @Override
    public Engineer save(Engineer engineer) {
        engineer.setIdEngineer("1");
        engineers[0] = engineer;
        return engineer;
    }
}
