package com.codegym.baithi.service.impl;

import com.codegym.baithi.model.Office;
import com.codegym.baithi.repository.OfficeRepository;
import com.codegym.baithi.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    OfficeRepository officeRepository;

    @Override
    public List<Office> findAll() {
        return (List<Office>) officeRepository.findAll();
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
    public List<Office> findAllByNameContaining(String name) {
        return null;
    }
}
