package com.codegym.baithi.repository;

import com.codegym.baithi.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
