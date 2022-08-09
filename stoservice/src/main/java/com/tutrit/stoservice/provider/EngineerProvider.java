package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;

public class EngineerProvider {
    Engineer engineer;
    EngineerRepository engineerRepository;

    public Engineer[] getEngineers() {
        engineerRepository = new EngineerRepository();

        for (int i = 1; i <= 3; i++) {
            engineer = new Engineer("" + i, "" + i, "" + i,"" + i,"" + i,"" + i, i, i);
            engineerRepository.createEngineer(engineer);
        }
        return engineerRepository.getEngineers();
    }
}
