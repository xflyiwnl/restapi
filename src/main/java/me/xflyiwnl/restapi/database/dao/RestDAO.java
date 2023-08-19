package me.xflyiwnl.restapi.database.dao;

import me.xflyiwnl.restapi.entity.Entity;

import java.util.List;

public interface RestDAO<T extends Entity> {

    T get(Object key);
    T get(T entity);
    void save(T entity);
    void delete(T entity);
    List<T> all();

}
