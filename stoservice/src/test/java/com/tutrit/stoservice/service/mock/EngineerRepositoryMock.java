package com.tutrit.stoservice.service.mock;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;

public class EngineerRepositoryMock extends EngineerRepository {
    Engineer engineer = new Engineer("1","One","Two","Three","Four","Five",6,7);

    @Override
    public Engineer save(Engineer engineer) {
        engineer.setId("1");
        engineers[0] = engineer;
        return engineer;
    }

    @Override
    public Engineer findById(String id) {
        return this.engineer;
    }
}
