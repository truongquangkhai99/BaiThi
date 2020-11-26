package com.codegym.baithi.service;


import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(long id);
    T save(T element);
    T delete(long id);
    List<T> findAllByNameContaining(String name);
}
