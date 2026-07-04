package com.library.repository;

import com.library.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // HQL - Get all permanent employees with department and skills (Hands-on 2)
    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.skillList WHERE e.permanent = 1")
    List<Employee> getAllPermanentEmployees();

    // HQL - Average salary of all employees (Hands-on 4)
    @Query("SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();

    // HQL - Average salary by department (Hands-on 4)
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    // Native Query - Get all employees (Hands-on 5)
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
