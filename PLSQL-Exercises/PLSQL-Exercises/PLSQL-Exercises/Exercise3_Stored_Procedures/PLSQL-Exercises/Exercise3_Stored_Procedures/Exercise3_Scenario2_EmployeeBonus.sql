CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    salary NUMBER,
    department VARCHAR2(50)
);

INSERT INTO employees VALUES (1, 'Alice Johnson', 70000, 'HR');
INSERT INTO employees VALUES (2, 'Bob Brown', 60000, 'IT');
INSERT INTO employees VALUES (3, 'Charlie Davis', 50000, 'HR');

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary * (1 + p_bonus_percentage / 100)
    WHERE department = p_department;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percentage || '% applied to department: ' || p_department);
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateEmployeeBonus;
/

BEGIN
    UpdateEmployeeBonus('HR', 10);
END;
/

SELECT * FROM employees;
