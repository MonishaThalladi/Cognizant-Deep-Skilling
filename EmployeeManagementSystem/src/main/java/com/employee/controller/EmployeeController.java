package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // ===== Basic CRUD =====
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/{id}/department")
    public ResponseEntity<Employee> getEmployeeWithDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeWithDepartment(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, 
                                                   @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // ===== Custom Query Methods (Exercise 5) =====
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchEmployeesByName(name));
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity<List<Employee>> getEmployeesWithSalaryGreaterThan(@PathVariable Double salary) {
        return ResponseEntity.ok(employeeService.getEmployeesWithSalaryGreaterThan(salary));
    }

    @GetMapping("/department/{deptId}/salary/{minSalary}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentAndMinSalary(
            @PathVariable Long deptId, 
            @PathVariable Double minSalary) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartmentAndMinSalary(deptId, minSalary));
    }

    // ===== Pagination and Sorting (Exercise 6) =====
    @GetMapping("/paged")
    public ResponseEntity<Page<Employee>> getEmployeesByDepartment(
            @RequestParam Long departmentId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return ResponseEntity.ok(employeeService.getEmployeesByDepartment(departmentId, pageable));
    }

    @GetMapping("/search/paged")
    public ResponseEntity<Page<Employee>> searchEmployeesByLastName(
            @RequestParam String lastName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return ResponseEntity.ok(employeeService.searchEmployeesByLastName(lastName, pageable));
    }
}
