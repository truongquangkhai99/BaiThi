package com.codegym.baithi.repository;

import com.codegym.baithi.model.Office;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface OfficeRepository extends PagingAndSortingRepository<Office,Long> {
}
