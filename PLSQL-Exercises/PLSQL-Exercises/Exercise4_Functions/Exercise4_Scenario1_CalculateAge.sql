CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    dob DATE
);

INSERT INTO customers VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'));
INSERT INTO customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'));
INSERT INTO customers VALUES (3, 'Bob Johnson', TO_DATE('1960-03-10', 'YYYY-MM-DD'));

CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END CalculateAge;
/

DECLARE
    v_age NUMBER;
BEGIN
    v_age := CalculateAge(TO_DATE('1985-05-15', 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('Age: ' || v_age);
END;
/

SELECT name, dob, CalculateAge(dob) AS age FROM customers;
