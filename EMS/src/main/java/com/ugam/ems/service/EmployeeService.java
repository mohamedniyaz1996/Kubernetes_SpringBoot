package com.ugam.ems.service;

import com.ugam.ems.dao.EmployeeRepository;
import com.ugam.ems.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> findById(int bookId) {
        return employeeRepository.findById(bookId);

    }

    public Optional<List<Employee>> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> findEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }
}
