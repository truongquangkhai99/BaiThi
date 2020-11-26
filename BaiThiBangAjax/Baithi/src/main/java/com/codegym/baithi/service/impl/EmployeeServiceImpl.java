package com.codegym.baithi.service.impl;

import com.codegym.baithi.model.Employee;
import com.codegym.baithi.repository.EmployeeRepository;
import com.codegym.baithi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee delete(long id) {
        Employee employee=this.findById(id);
        employeeRepository.delete(employee);
        return new Employee();
    }

    @Override
    public List<Employee> findAllByNameContaining(String name) {
        return (List<Employee>) employeeRepository.findAllByNameContaining(name);
    }
}
