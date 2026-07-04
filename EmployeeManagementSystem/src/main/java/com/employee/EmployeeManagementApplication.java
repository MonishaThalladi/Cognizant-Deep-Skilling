package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // Enable Auditing (Exercise 7)
public class EmployeeManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
        System.out.println("🚀 Employee Management System Started!");
        System.out.println("📊 H2 Console: http://localhost:8080/ems/h2-console");
        System.out.println("📋 API Base: http://localhost:8080/ems/api");
    }
}
