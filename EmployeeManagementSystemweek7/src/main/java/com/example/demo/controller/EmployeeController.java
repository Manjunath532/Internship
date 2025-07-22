package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repositroy.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // GET all employees - ADMIN only
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    // GET employee by ID - ADMIN only
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> empOpt = employeeRepository.findById(id);
        return empOpt.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // CREATE new employee - ADMIN only
    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
        Employee savedEmp = employeeRepository.save(emp);
        return ResponseEntity.ok(savedEmp);
    }

    // UPDATE employee - ADMIN only
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        emp.setId(id);
        Employee updatedEmp = employeeRepository.save(emp);
        return ResponseEntity.ok(updatedEmp);
    }

    // DELETE employee - ADMIN only
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("✅ Employee with ID " + id + " deleted successfully.");
    }
}
