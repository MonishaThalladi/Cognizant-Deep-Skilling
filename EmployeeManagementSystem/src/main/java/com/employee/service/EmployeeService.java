package com.employee.service;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    // Create
    public Employee createEmployee(Employee employee) {
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department department = departmentService.getDepartmentById(employee.getDepartment().getId());
            employee.setDepartment(department);
        }
        return employeeRepository.save(employee);
    }

    // Read - All
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Read - By ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Read - By ID with Department
    public Employee getEmployeeWithDepartment(Long id) {
        return employeeRepository.findByIdWithDepartment(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Update
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = getEmployeeById(id);
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
        employee.setSalary(employeeDetails.getSalary());
        
        if (employeeDetails.getDepartment() != null && employeeDetails.getDepartment().getId() != null) {
            Department department = departmentService.getDepartmentById(employeeDetails.getDepartment().getId());
            employee.setDepartment(department);
        }
        return employeeRepository.save(employee);
    }

    // Delete
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // ===== Custom Query Methods (Exercise 5) =====
    public List<Employee> getEmployeesByDepartmentAndMinSalary(Long deptId, Double minSalary) {
        return employeeRepository.findEmployeesByDepartmentAndMinSalary(deptId, minSalary);
    }

    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.searchByName(name);
    }

    public List<Employee> getEmployeesWithSalaryGreaterThan(Double salary) {
        return employeeRepository.findEmployeesWithSalaryGreaterThanNative(salary);
    }

    // ===== Pagination (Exercise 6) =====
    public Page<Employee> getEmployeesByDepartment(Long departmentId, Pageable pageable) {
        return employeeRepository.findByDepartmentId(departmentId, pageable);
    }

    public Page<Employee> searchEmployeesByLastName(String lastName, Pageable pageable) {
        return employeeRepository.findByLastNameContainingIgnoreCase(lastName, pageable);
    }
}
