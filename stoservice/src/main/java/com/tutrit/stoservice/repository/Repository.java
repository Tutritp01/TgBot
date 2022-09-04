package com.tutrit.stoservice.repository;

import jdk.jshell.spi.ExecutionControl;

public interface Repository<T, E> {
    T save(T obj);

    void saveAll(Iterable<T> obj);

    void saveAll(T[] obj) throws Exception;

    T find(T obj);

    Iterable<T> findAll();

    T findById(E id);

    T update(T obj);

    boolean delete(T obj);

    boolean deleteById(E id);

    int count();
}
