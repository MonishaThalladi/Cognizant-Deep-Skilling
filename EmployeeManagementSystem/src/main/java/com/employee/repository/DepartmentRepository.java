package com.employee.repository;

import com.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query methods (Exercise 3)
    Optional<Department> findByName(String name);
    
    List<Department> findByNameContainingIgnoreCase(String name);

    // Custom query with @Query (Exercise 5)
    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.employees WHERE d.id = :id")
    Optional<Department> findByIdWithEmployees(@Param("id") Long id);

    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) > :minEmployees")
    List<Department> findDepartmentsWithMinEmployees(@Param("minEmployees") int minEmployees);
}
