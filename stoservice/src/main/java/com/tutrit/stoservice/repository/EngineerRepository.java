package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Engineer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class EngineerRepository {
    Engineer ext;
    Engineer extFind;
    Engineer[] engineers = new Engineer[3];
    Logger log = LoggerFactory.getLogger(EngineerRepository.class);

    public Engineer createEngineer(Engineer engineer) {
        int ret = 0;
        for (int i = 0; i < engineers.length; i++) {
            if (engineers[i] == null) {
                engineer.setIdEngineer(count(i));
                ret = i;
                engineers[i] = engineer;
                if ((i * 2) >= engineers.length) {
                    engineers = Arrays.copyOf(engineers, engineers.length);
                }
                break;
            }
        }
        return engineers[ret];
    }
    public Engineer[] getEngineers() {
        return engineers;
    }

    public Engineer findEngineer(int i) {
        if (i > (engineers.length - 1)) {
            log.info("Array out of bounds");
            return new Engineer();
        }
        return engineers[i - 1];
    }

    public Engineer findEngineer(String a) {
        int i = Integer.parseInt(a);
        return findEngineer(i);
    }

    public Engineer findEngineer(Engineer engineer) {
        Engineer find = extract(engineer);
        for (Engineer e : engineers) {
            extFind = extract(e);
            if (find.equals(extFind)) {
                return e;
            }
        }
        log.info("Not found");
        return new Engineer();
    }

    public Engineer updateEngineer(Engineer engineer, int i) {
        engineers[i - 1] = engineer;
        engineers[i - 1].setIdEngineer(String.valueOf(i));
        return engineers[i - 1];
    }

    public void deleteEngineer(int i) {
        for (int j = (i - 1); j < engineers.length - 1; j++) {
            if (engineers[j + 1] != null) {
                engineers[j] = engineers[j + 1];
                engineers[j].setIdEngineer(count(j));
            } else {
                engineers[j] = null;
            }
        }
    }

    public void deleteEngineer(String a) {
        int i = Integer.parseInt(a);
        deleteEngineer(i);
    }

    public void deleteEngineer(Engineer engineer) {
        Engineer find = extract(engineer);
        int i = Integer.parseInt(findEngineer(find).getIdEngineer());
        deleteEngineer(i);
    }

    public String count(int i) {
        i = i + 1;
        return String.valueOf(i);
    }

    public Engineer extract(Engineer engineer) {
        ext = new Engineer();
        ext.setFirstName(engineer.getFirstName());
        ext.setLastName(engineer.getLastName());
        ext.setExperience(engineer.getExperience());
        ext.setFunction(engineer.getFunction());
        ext.setCategory(engineer.getCategory());
        ext.setEducation(engineer.getEducation());
        ext.setGeneralExperience(engineer.getGeneralExperience());
        return ext;
    }
}
