package com.tutrit.service;

import com.tutrit.bean.Engineer;
import com.tutrit.client.EngineerClient;
import org.springframework.stereotype.Service;

@Service
public class EngineerService {

    private final EngineerClient engineerClient;

    public EngineerService(final EngineerClient engineerClient) {
        this.engineerClient = engineerClient;
    }

    public Engineer save(Engineer engineer) {
        return engineerClient.save(engineer);
    }

    public Engineer findById(String id) {
        return engineerClient.findById(id);
    }
}
