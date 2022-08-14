package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;

public class EngineerProvider {
    //private Engineer engineer;
    //private EngineerRepository engineerRepository;

    public Engineer[] getEngineers() {
        EngineerRepository engineerRepository = new EngineerRepository();

        for (int i = 1; i <= 3; i++) {
            Engineer engineer = new Engineer("" + i, "" + i, "" + i,"" + i,"" + i,"" + i, i, i);
            engineerRepository.createEngineer(engineer);
        }
        return engineerRepository.getEngineers();
    }
}
