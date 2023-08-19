package me.xflyiwnl.restapi.service;

import me.xflyiwnl.restapi.entity.Entity;

import java.util.List;

public interface RestService<T extends Entity> {

    T get(Object key);
    T get(T entity);
    void save(T entity);
    void delete(T entity);
    List<T> all();
}
