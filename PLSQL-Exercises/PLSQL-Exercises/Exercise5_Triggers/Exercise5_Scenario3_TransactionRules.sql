CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    balance NUMBER
);

CREATE TABLE transactions (
    transaction_id NUMBER PRIMARY KEY,
    account_id NUMBER,
    amount NUMBER,
    transaction_type VARCHAR2(10)
);

INSERT INTO accounts VALUES (1, 1000);
INSERT INTO accounts VALUES (2, 500);

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.transaction_type = 'Withdrawal' THEN
        SELECT balance INTO v_balance
        FROM accounts
        WHERE account_id = :NEW.account_id;
        
        IF v_balance < :NEW.amount THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance');
        END IF;
        
    ELSIF :NEW.transaction_type = 'Deposit' THEN
        IF :NEW.amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit must be positive');
        END IF;
    END IF;
END CheckTransactionRules;
/

INSERT INTO transactions VALUES (1, 1, 200, 'Withdrawal');
INSERT INTO transactions VALUES (2, 1, 50, 'Deposit');
INSERT INTO transactions VALUES (3, 2, 600, 'Withdrawal');

SELECT * FROM transactions;
