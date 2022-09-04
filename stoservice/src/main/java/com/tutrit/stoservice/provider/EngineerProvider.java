package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Engineer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EngineerProvider implements DemoDataProvider{

    public static Engineer[] getEngineers(int k) {
        Engineer[] engineers = new Engineer[k];
        for (int i = 0; i < k; i++) {
            engineers[i] = new Engineer("id" + i, "firstName" + i, "lastName" + i, "function" + i, "category" + i, "education" + i, i, i);
        }
        return engineers;
    }

    @Override
    public List<Object> getInstances() {
        return Arrays.asList(getEngineers(5));
    }

    public Engineer[] getEngineers2(int k) {
        Engineer[] engineers = new Engineer[k];
        for (int i = 0; i < k; i++) {
            engineers[i] = new Engineer("id" + i, "firstName" + i, "lastName" + i, "function" + i, "category" + i, "education" + i, i, i);
        }
        return engineers;
    }
}
