package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Engineer;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.StreamSupport;

public class EngineerRepository implements Repository<Engineer, String>, MyIdGenerator<Engineer> {

    public static Engineer[] engineers = new Engineer[3];
    public static int counted = 0;

    @Override
    public Engineer save(Engineer engineer) {
        int returnIndex = 0;
        for (int i = 0; i < engineers.length; i++) {
            if (engineers[i] == null) {
                setUUID(engineer);
                returnIndex = i;
                engineers[i] = engineer;
                if ((i * 2) >= engineers.length) {
                    engineers = Arrays.copyOf(engineers, engineers.length + 5);
                }
                break;
            }
        }
        return engineers[returnIndex];
    }

    @Override
    public void saveAll(Iterable<Engineer> engineersInput) {
        for (Engineer engineer : engineersInput) {
            save(engineer);
        }
    }

    @Override
    public Engineer find(Engineer engineer) {
        for (Engineer engineerRepository : engineers) {
            if (engineerRepository != null && engineerRepository.getId().equals(engineer.getId())) {
                return engineerRepository;
            }
        }
        return null;
    }

    @Override
    public Iterable<Engineer> findAll() {
        int countExport = 0;
        for (Engineer eng : engineers) {
            if (eng != null) {
                countExport++;
            }
        }
        Engineer[] engineersExport = new Engineer[countExport];
        countExport = 0;
        for (Engineer eng : engineers) {
            if (eng != null) {
                engineersExport[countExport] = eng;
                countExport++;
            }
        }
        return Arrays.asList(engineersExport);
    }

    @Override
    public Engineer findById(String id) {
        for (Engineer engineerRepository : engineers) {
            if (engineerRepository != null && engineerRepository.getId().equals(id)) {
                return engineerRepository;
            }
        }
        return null;
    }

    @Override
    public Engineer update(Engineer engineer) {
        if (find(engineer) != null) {
            int i = Integer.parseInt(find(engineer).getId()) - 1;
            engineers[i] = engineer;
            return engineers[i];
        }
        return null;
    }

    @Override
    public boolean delete(Engineer engineer) {
        for (int i = 0; i < engineers.length; i++) {
            if (engineers[i] != null && engineers[i].getId().equals(engineer.getId())) {
                engineers[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        for (int i = 0; i < engineers.length; i++) {
            if (engineers[i] != null && engineers[i].getId().equals(id)) {
                engineers[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return (int) StreamSupport.stream(findAll().spliterator(), false).count();
    }

    @Override
    public void setUUID(Engineer engineer) {
        engineer.setId(UUID.randomUUID().toString());
    }
}
