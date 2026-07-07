CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    balance NUMBER,
    last_modified DATE
);

INSERT INTO customers VALUES (1, 'John Doe', 1000, SYSDATE);
INSERT INTO customers VALUES (2, 'Jane Smith', 2000, SYSDATE);

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON customers
FOR EACH ROW
BEGIN
    :NEW.last_modified := SYSDATE;
    DBMS_OUTPUT.PUT_LINE('LastModified updated for customer: ' || :NEW.customer_id);
END UpdateCustomerLastModified;
/

UPDATE customers SET balance = 1500 WHERE customer_id = 1;

SELECT * FROM customers;
