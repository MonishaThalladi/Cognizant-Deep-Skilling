CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER
);

INSERT INTO accounts VALUES (101, 1, 1000);
INSERT INTO accounts VALUES (102, 1, 2000);
INSERT INTO accounts VALUES (103, 2, 500);

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_account_id NUMBER, p_customer_id NUMBER, p_balance NUMBER);
    PROCEDURE CloseAccount(p_account_id NUMBER);
    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(p_account_id NUMBER, p_customer_id NUMBER, p_balance NUMBER) IS
    BEGIN
        INSERT INTO accounts VALUES (p_account_id, p_customer_id, p_balance);
        DBMS_OUTPUT.PUT_LINE('Account opened: ' || p_account_id);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Account ID already exists');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END OpenAccount;

    PROCEDURE CloseAccount(p_account_id NUMBER) IS
    BEGIN
        DELETE FROM accounts WHERE account_id = p_account_id;
        DBMS_OUTPUT.PUT_LINE('Account closed: ' || p_account_id);
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Account not found');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END CloseAccount;

    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(balance) INTO v_total
        FROM accounts
        WHERE customer_id = p_customer_id;
        RETURN NVL(v_total, 0);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END GetTotalBalance;

END AccountOperations;
/

BEGIN
    AccountOperations.OpenAccount(104, 1, 3000);
    DBMS_OUTPUT.PUT_LINE('Total Balance: $' || AccountOperations.GetTotalBalance(1));
    AccountOperations.CloseAccount(103);
END;
/

SELECT * FROM accounts;
