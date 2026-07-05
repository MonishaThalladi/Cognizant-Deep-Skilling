CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    email VARCHAR2(100),
    balance NUMBER
);

INSERT INTO customers VALUES (1, 'John Doe', 'john@email.com', 1000);
INSERT INTO customers VALUES (2, 'Jane Smith', 'jane@email.com', 2000);

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_email IN VARCHAR2,
    p_balance IN NUMBER
) IS
    duplicate_customer EXCEPTION;
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM customers
    WHERE customer_id = p_customer_id;
    
    IF v_count > 0 THEN
        RAISE duplicate_customer;
    END IF;
    
    INSERT INTO customers VALUES (p_customer_id, p_name, p_email, p_balance);
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('✅ Customer ' || p_name || ' added successfully');
                         
EXCEPTION
    WHEN duplicate_customer THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('❌ Error: Customer ID ' || p_customer_id || ' already exists');
        
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
END AddNewCustomer;
/

BEGIN
    AddNewCustomer(3, 'Alice Brown', 'alice@email.com', 1500);
END;
/

SELECT * FROM customers;
