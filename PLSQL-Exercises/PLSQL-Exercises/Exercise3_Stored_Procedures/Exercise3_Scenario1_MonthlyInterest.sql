CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    account_type VARCHAR2(20),
    balance NUMBER,
    last_modified DATE
);

INSERT INTO accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO accounts VALUES (2, 2, 'Savings', 500, SYSDATE);
INSERT INTO accounts VALUES (3, 3, 'Checking', 2000, SYSDATE);
INSERT INTO accounts VALUES (4, 4, 'Savings', 3000, SYSDATE);

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_interest_rate NUMBER := 0.01;
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

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM accounts;
