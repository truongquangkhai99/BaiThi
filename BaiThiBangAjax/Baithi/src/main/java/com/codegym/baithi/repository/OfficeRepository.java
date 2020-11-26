package com.codegym.baithi.repository;

import com.codegym.baithi.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface OfficeRepository extends JpaRepository<Office,Long> {
}
