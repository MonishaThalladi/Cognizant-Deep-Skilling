CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER,
    last_modified DATE
);

INSERT INTO accounts VALUES (1, 1, 1000, SYSDATE);
INSERT INTO accounts VALUES (2, 2, 500, SYSDATE);

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_from_balance NUMBER;
BEGIN
    SELECT balance INTO v_from_balance
    FROM accounts
    WHERE account_id = p_from_account;
    
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
    END IF;
    
    UPDATE accounts SET balance = balance - p_amount WHERE account_id = p_from_account;
    UPDATE accounts SET balance = balance + p_amount WHERE account_id = p_to_account;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transferred: $' || p_amount || 
                         ' from account ' || p_from_account || 
                         ' to account ' || p_to_account);
                         
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFunds;
/

BEGIN
    TransferFunds(1, 2, 200);
END;
/

SELECT * FROM accounts;
