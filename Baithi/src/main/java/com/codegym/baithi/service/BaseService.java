package com.codegym.baithi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T> {
    Iterable<T> findAll();
    Page<T> findAll(Pageable pageable);
    T findById(long id);
    T save(T element);
    T delete(long id);
    Page<T> findAllByNameContaining(String name,Pageable pageable);
}
