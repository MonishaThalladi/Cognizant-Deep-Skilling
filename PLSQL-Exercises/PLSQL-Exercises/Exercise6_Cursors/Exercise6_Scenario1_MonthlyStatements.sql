CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100)
);

CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER
);

CREATE TABLE transactions (
    transaction_id NUMBER PRIMARY KEY,
    account_id NUMBER,
    amount NUMBER,
    transaction_date DATE
);

INSERT INTO customers VALUES (1, 'John Doe');
INSERT INTO customers VALUES (2, 'Jane Smith');

INSERT INTO accounts VALUES (101, 1, 1000);
INSERT INTO accounts VALUES (102, 2, 2000);

INSERT INTO transactions VALUES (1, 101, 500, SYSDATE);
INSERT INTO transactions VALUES (2, 102, 300, SYSDATE);
INSERT INTO transactions VALUES (3, 101, 200, SYSDATE);

DECLARE
    CURSOR cur_customer IS
        SELECT customer_id, name FROM customers;
    
    CURSOR cur_transactions(p_customer_id NUMBER) IS
        SELECT t.transaction_id, t.amount, t.transaction_date
        FROM transactions t
        JOIN accounts a ON t.account_id = a.account_id
        WHERE a.customer_id = p_customer_id;
BEGIN
    FOR customer_rec IN cur_customer LOOP
        DBMS_OUTPUT.PUT_LINE('=== Statement for: ' || customer_rec.name || ' ===');
        
        FOR trans_rec IN cur_transactions(customer_rec.customer_id) LOOP
            DBMS_OUTPUT.PUT_LINE('Transaction: $' || trans_rec.amount || 
                                 ' on ' || trans_rec.transaction_date);
        END LOOP;
        
        DBMS_OUTPUT.PUT_LINE('--- End of Statement ---');
    END LOOP;
END;
/
