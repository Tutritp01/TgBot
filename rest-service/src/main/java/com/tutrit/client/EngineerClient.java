package com.tutrit.client;

import com.tutrit.bean.Engineer;
import com.tutrit.persistence.EngineerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EngineerClient {
    @Autowired(required = false)
    private EngineerPersistence engineerPersistence;

    public Engineer save(Engineer engineer) {
        return engineerPersistence.save(engineer);
    }

    public Engineer findById(String id) {
        try {
            return engineerPersistence.findById(id);
        } catch (RuntimeException e) {
            return new Engineer();
        }
    }
}
