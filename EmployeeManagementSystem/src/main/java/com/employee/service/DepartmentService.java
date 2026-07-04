package com.employee.service;

import com.employee.entity.Department;
import com.employee.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    // Create
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Read - All
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Read - By ID
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    // Read - By ID with Employees
    public Department getDepartmentWithEmployees(Long id) {
        return departmentRepository.findByIdWithEmployees(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    // Update
    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = getDepartmentById(id);
        department.setName(departmentDetails.getName());
        department.setDescription(departmentDetails.getDescription());
        return departmentRepository.save(department);
    }

    // Delete
    public void deleteDepartment(Long id) {
        Department department = getDepartmentById(id);
        if (!department.getEmployees().isEmpty()) {
            throw new RuntimeException("Cannot delete department with employees!");
        }
        departmentRepository.deleteById(id);
    }

    // Search
    public List<Department> searchDepartmentsByName(String name) {
        return departmentRepository.findByNameContainingIgnoreCase(name);
    }
}
