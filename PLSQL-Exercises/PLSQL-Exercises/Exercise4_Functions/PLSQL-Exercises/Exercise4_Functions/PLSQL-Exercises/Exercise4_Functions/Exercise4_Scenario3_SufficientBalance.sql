CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER
);

INSERT INTO accounts VALUES (1, 1, 1000);
INSERT INTO accounts VALUES (2, 2, 500);

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_account_id;
    
    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END HasSufficientBalance;
/

DECLARE
    v_result BOOLEAN;
BEGIN
    v_result := HasSufficientBalance(1, 200);
    IF v_result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance: YES');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Sufficient balance: NO');
    END IF;
END;
/

SELECT account_id, 
       balance,
       CASE WHEN HasSufficientBalance(account_id, 200) = TRUE THEN 'YES' ELSE 'NO' END 
       AS Sufficient_Balance
FROM accounts;
