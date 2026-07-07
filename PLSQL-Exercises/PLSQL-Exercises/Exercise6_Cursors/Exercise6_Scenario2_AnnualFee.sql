CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    balance NUMBER
);

INSERT INTO accounts VALUES (101, 1000);
INSERT INTO accounts VALUES (102, 2000);
INSERT INTO accounts VALUES (103, 500);

DECLARE
    CURSOR cur_accounts IS
        SELECT account_id, balance FROM accounts;
    
    v_fee NUMBER := 25;
BEGIN
    FOR acc_rec IN cur_accounts LOOP
        UPDATE accounts
        SET balance = balance - v_fee
        WHERE account_id = acc_rec.account_id;
        
        DBMS_OUTPUT.PUT_LINE('Account ' || acc_rec.account_id || 
                             ' | Old: $' || acc_rec.balance || 
                             ' | New: $' || (acc_rec.balance - v_fee));
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual fee applied to all accounts.');
END;
/

SELECT * FROM accounts;
