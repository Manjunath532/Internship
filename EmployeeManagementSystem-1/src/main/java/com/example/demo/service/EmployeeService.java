package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;



@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(int id) {
        return repo.findById(id);
    }

    public Employee create(Employee emp) {
        repo.save(emp);
        return emp;
    }

    public Employee update(int id, Employee emp) {
        repo.update(id, emp);
        return emp;
    }

    public void delete(int id) {
        repo.delete(id);
    }
}

