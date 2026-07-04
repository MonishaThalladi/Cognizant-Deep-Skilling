package com.library.service;

import com.library.entity.Employee;
import com.library.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get employee by ID
    @Transactional
    public Employee get(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Save employee
    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    // Get all permanent employees (Hands-on 2)
    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    // Get average salary (Hands-on 4)
    @Transactional
    public double getAverageSalary() {
        return employeeRepository.getAverageSalary();
    }

    // Get average salary by department (Hands-on 4)
    @Transactional
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }

    // Get all employees using native query (Hands-on 5)
    @Transactional
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }
}
