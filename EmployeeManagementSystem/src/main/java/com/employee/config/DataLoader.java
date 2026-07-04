package com.employee.config;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {
        // Create Departments
        Department it = new Department();
        it.setName("IT");
        it.setDescription("Information Technology Department");
        departmentRepository.save(it);

        Department hr = new Department();
        hr.setName("HR");
        hr.setDescription("Human Resources Department");
        departmentRepository.save(hr);

        Department finance = new Department();
        finance.setName("Finance");
        finance.setDescription("Finance and Accounting Department");
        departmentRepository.save(finance);

        // Create Employees
        Employee emp1 = new Employee();
        emp1.setFirstName("John");
        emp1.setLastName("Doe");
        emp1.setEmail("john.doe@company.com");
        emp1.setPhoneNumber("123-456-7890");
        emp1.setSalary(75000.0);
        emp1.setDepartment(it);
        employeeRepository.save(emp1);

        Employee emp2 = new Employee();
        emp2.setFirstName("Jane");
        emp2.setLastName("Smith");
        emp2.setEmail("jane.smith@company.com");
        emp2.setPhoneNumber("123-456-7891");
        emp2.setSalary(65000.0);
        emp2.setDepartment(it);
        employeeRepository.save(emp2);

        Employee emp3 = new Employee();
        emp3.setFirstName("Bob");
        emp3.setLastName("Johnson");
        emp3.setEmail("bob.johnson@company.com");
        emp3.setPhoneNumber("123-456-7892");
        emp3.setSalary(55000.0);
        emp3.setDepartment(hr);
        employeeRepository.save(emp3);

        Employee emp4 = new Employee();
        emp4.setFirstName("Alice");
        emp4.setLastName("Brown");
        emp4.setEmail("alice.brown@company.com");
        emp4.setPhoneNumber("123-456-7893");
        emp4.setSalary(80000.0);
        emp4.setDepartment(finance);
        employeeRepository.save(emp4);

        Employee emp5 = new Employee();
        emp5.setFirstName("Charlie");
        emp5.setLastName("Wilson");
        emp5.setEmail("charlie.wilson@company.com");
        emp5.setPhoneNumber("123-456-7894");
        emp5.setSalary(70000.0);
        emp5.setDepartment(finance);
        employeeRepository.save(emp5);

        System.out.println("✅ Sample data loaded!");
        System.out.println("📊 Departments: " + departmentRepository.count());
        System.out.println("👨‍💼 Employees: " + employeeRepository.count());
    }
}
