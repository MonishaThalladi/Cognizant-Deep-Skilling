package com.employee.repository;

import com.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // ===== Derived Query Methods (Exercise 3 & 5) =====
    List<Employee> findByLastName(String lastName);
    
    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
    
    List<Employee> findByDepartmentId(Long departmentId);
    
    Optional<Employee> findByEmail(String email);
    
    List<Employee> findBySalaryGreaterThan(Double salary);
    
    List<Employee> findBySalaryBetween(Double min, Double max);
    
    // ===== Custom Query Methods with @Query (Exercise 5) =====
    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.department WHERE e.id = :id")
    Optional<Employee> findByIdWithDepartment(@Param("id") Long id);
    
    @Query("SELECT e FROM Employee e WHERE e.department.id = :deptId AND e.salary > :minSalary")
    List<Employee> findEmployeesByDepartmentAndMinSalary(@Param("deptId") Long deptId, 
                                                          @Param("minSalary") Double minSalary);
    
    @Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :name, '%')) " +
           "OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Employee> searchByName(@Param("name") String name);
    
    // ===== Native Query (Exercise 5) =====
    @Query(value = "SELECT * FROM employees WHERE salary > :salary", nativeQuery = true)
    List<Employee> findEmployeesWithSalaryGreaterThanNative(@Param("salary") Double salary);
    
    // ===== Pagination and Sorting (Exercise 6) =====
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);
    
    Page<Employee> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
}
