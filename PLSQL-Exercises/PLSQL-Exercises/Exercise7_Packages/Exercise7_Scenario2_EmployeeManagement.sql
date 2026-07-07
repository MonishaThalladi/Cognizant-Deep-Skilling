CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    salary NUMBER
);

INSERT INTO employees VALUES (1, 'Alice Johnson', 70000);
INSERT INTO employees VALUES (2, 'Bob Brown', 60000);

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER);
    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER) IS
    BEGIN
        INSERT INTO employees VALUES (p_id, p_name, p_salary);
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID already exists');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END HireEmployee;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER) IS
    BEGIN
        UPDATE employees
        SET name = p_name, salary = p_salary
        WHERE employee_id = p_id;
        DBMS_OUTPUT.PUT_LINE('Employee updated: ' || p_name);
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee not found');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT salary INTO v_salary FROM employees WHERE employee_id = p_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END CalculateAnnualSalary;

END EmployeeManagement;
/

BEGIN
    EmployeeManagement.HireEmployee(3, 'Charlie Davis', 50000);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: $' || EmployeeManagement.CalculateAnnualSalary(1));
END;
/

SELECT * FROM employees;
