package com.tutrit.persistence;

import com.tutrit.bean.Engineer;

public interface EngineerPersistence {
    Engineer save(Engineer engineer);

    Engineer findById(String id);

    Iterable<Engineer> findAll();

    Engineer update(Engineer engineer);

    boolean delete(Engineer engineer);
}
