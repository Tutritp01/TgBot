package com.tutrit.persistence;

import com.tutrit.bean.Engineer;
import com.tutrit.service.UUIDWrapper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryEngineerPersistence implements EngineerPersistence {
    private final UUIDWrapper uuid;
    private static final Map<String, Engineer> engineers = new ConcurrentHashMap<>();

    public MemoryEngineerPersistence(UUIDWrapper uuid) {
        this.uuid = uuid;
    }

    @Override
    public Engineer save(Engineer engineer) {
        String newId = uuid.getID();
        engineer.setUuid(newId);
        engineers.put(newId,engineer);
        return engineers.get(newId);
    }

    @Override
    public Engineer findById(String id) {
        return engineers.get(id);
    }

    @Override
    public Iterable<Engineer> findAll() {
        return List.copyOf(engineers.values());
    }

    @Override
    public Engineer update(String idOld, Engineer newEngineer) {
        newEngineer.setUuid(idOld);
        engineers.put(idOld, newEngineer);
        return engineers.get(idOld);
    }

    @Override
    public boolean delete(String id) {
        var result = engineers.remove(id);
        return (result!=null);
    }

    public void deleteAll() {
        engineers.clear();
    }
}
