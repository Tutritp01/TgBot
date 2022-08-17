package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Engineer;


public class EngineerProvider {

    public Engineer[] getEngineers(int k) {
        Engineer[] engineers = new Engineer[k];
        for (int i = 0; i < k; i++) {
            engineers[i] = new Engineer("id" + i, "firstName" + i, "lastName" + i, "function" + i, "category" + i, "education" + i, i, i);
        }
        return engineers;
    }
}
