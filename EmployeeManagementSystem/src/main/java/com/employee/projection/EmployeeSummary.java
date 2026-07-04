package com.employee.projection;

import org.springframework.beans.factory.annotation.Value;

// Interface-based Projection (Exercise 8)
public interface EmployeeSummary {
    Long getId();
    String getFullName();
    String getEmail();
    Double getSalary();
    
    // Using @Value for computed fields
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getDisplayName();
    
    @Value("#{target.salary * 1.1}")
    Double getSalaryWithBonus();
}
