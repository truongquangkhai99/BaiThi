package com.codegym.baithi.service.impl;

import com.codegym.baithi.model.Office;
import com.codegym.baithi.repository.OfficeRepository;
import com.codegym.baithi.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    OfficeRepository officeRepository;
    @Override
    public Iterable<Office> findAll() {
        return null;
    }

    @Override
    public Page<Office> findAll(Pageable pageable) {
        return officeRepository.findAll(pageable);
    }

    @Override
    public Office findById(long id) {
        return officeRepository.findById(id).orElse(null);
    }

    @Override
    public Office save(Office element) {
        return null;
    }

    @Override
    public Office delete(long id) {
        return null;
    }

    @Override
    public Page<Office> findAllByNameContaining(String name, Pageable pageable) {
        return null;
    }
}
