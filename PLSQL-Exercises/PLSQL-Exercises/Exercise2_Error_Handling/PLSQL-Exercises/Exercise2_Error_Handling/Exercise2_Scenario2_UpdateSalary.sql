CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    salary NUMBER,
    department VARCHAR2(50)
);

INSERT INTO employees VALUES (1, 'Alice Johnson', 70000, 'HR');
INSERT INTO employees VALUES (2, 'Bob Brown', 60000, 'IT');

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) IS
    v_current_salary NUMBER;
    employee_not_found EXCEPTION;
BEGIN
    SELECT salary INTO v_current_salary
    FROM employees
    WHERE employee_id = p_employee_id;
    
    UPDATE employees
    SET salary = salary * (1 + p_percentage / 100)
    WHERE employee_id = p_employee_id;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('✅ Salary updated for employee ' || p_employee_id || 
                         ' by ' || p_percentage || '%');
                         
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('❌ Error: Employee ' || p_employee_id || ' not found');
        
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
END UpdateSalary;
/

BEGIN
    UpdateSalary(1, 10);
END;
/

SELECT * FROM employees;
