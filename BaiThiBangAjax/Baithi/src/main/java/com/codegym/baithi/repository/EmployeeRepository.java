package com.codegym.baithi.repository;

import com.codegym.baithi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findAllByNameContaining(String name);
}
