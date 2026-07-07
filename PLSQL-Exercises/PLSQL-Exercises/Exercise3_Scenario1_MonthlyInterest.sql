-- ============================================================
-- EXERCISE 3, SCENARIO 1: Process Monthly Interest
-- Description: Applies 1% monthly interest to all savings accounts
-- ============================================================

-- Create accounts table
CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    account_type VARCHAR2(20),
    balance NUMBER,
    last_modified DATE
);

-- Insert sample data
INSERT INTO accounts VALUES (1, 101, 'Savings', 1000, SYSDATE);
INSERT INTO accounts VALUES (2, 102, 'Savings', 500, SYSDATE);
INSERT INTO accounts VALUES (3, 103, 'Checking', 2000, SYSDATE);
INSERT INTO accounts VALUES (4, 104, 'Savings', 3000, SYSDATE);

-- Create Stored Procedure
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_interest_rate NUMBER := 0.01;  -- 1% interest
    v_count NUMBER := 0;
BEGIN
    FOR acc_rec IN (SELECT account_id, balance 
                    FROM accounts 
                    WHERE account_type = 'Savings') LOOP
        
        UPDATE accounts
        SET balance = balance * (1 + v_interest_rate),
            last_modified = SYSDATE
        WHERE account_id = acc_rec.account_id;
        
        v_count := v_count + 1;
        DBMS_OUTPUT.PUT_LINE('Account ' || acc_rec.account_id || 
                             ' | Old: $' || acc_rec.balance || 
                             ' | New: $' || (acc_rec.balance * (1 + v_interest_rate)));
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to ' || v_count || ' savings accounts.');
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END ProcessMonthlyInterest;
/

-- Execute the procedure
BEGIN
    ProcessMonthlyInterest;
END;
/

-- Check results
SELECT * FROM accounts;
