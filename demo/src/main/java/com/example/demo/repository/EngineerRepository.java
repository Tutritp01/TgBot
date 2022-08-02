package com.example.demo.repository;

import com.example.demo.bean.Engineer;

import java.util.Arrays;

public class EngineerRepository {
    public static Engineer[] engineers = new Engineer[3];

    public Engineer[] createEngineer(Engineer engineer) {

        for (int i = 0; i < engineers.length; i++) {
            if (engineers[i] == null) {
                engineer.setIdEngineer(count(i));
                engineers[i] = engineer;
                if ((i * 2) >= engineers.length) {
                    Engineer[] engineersTemp = Arrays.copyOf(engineers, (engineers.length + 5));
                    engineers = engineersTemp;
                }
                break;
            }
        }
        return engineers;
    }

    public Engineer readEngineer(int i) {
        return engineers[i - 1];
    }

    public Engineer[] updateEngineer(Engineer engineer, int i) {
        engineers[i - 1] = engineer;
        engineers[i - 1].setIdEngineer(String.valueOf(i));
        return engineers;
    }

    public Engineer[] deleteEngineer(int i) {
        for (int j = (i - 1); j < engineers.length - 1; j++) {
            if (engineers[j + 1] != null) {
                engineers[j] = engineers[j + 1];
                engineers[j].setIdEngineer(String.valueOf((j + 1)));
            } else {
                engineers[j] = null;
            }
        }
        return engineers;
    }

    public String count(int i) {
        i = i + 1;
        String count = String.valueOf(i);
        return count;
    }
}
