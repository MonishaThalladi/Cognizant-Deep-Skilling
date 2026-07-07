CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    balance NUMBER
);

INSERT INTO customers VALUES (1, 'John Doe', 1000);
INSERT INTO customers VALUES (2, 'Jane Smith', 2000);

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
    FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO customers VALUES (p_id, p_name, p_balance);
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END AddCustomer;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
    BEGIN
        UPDATE customers
        SET name = p_name, balance = p_balance
        WHERE customer_id = p_id;
        DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_name);
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer not found');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END UpdateCustomer;

    FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT balance INTO v_balance FROM customers WHERE customer_id = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END GetBalance;

END CustomerManagement;
/

BEGIN
    CustomerManagement.AddCustomer(3, 'Alice Brown', 1500);
    DBMS_OUTPUT.PUT_LINE('Balance: $' || CustomerManagement.GetBalance(1));
END;
/

SELECT * FROM customers;
