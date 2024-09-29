package com.estramipyme.data.interfaces;

import java.util.List;

public interface IRepository<T,ID> {
    T findById(ID id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(ID id);
}