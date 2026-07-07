CREATE TABLE transactions (
    transaction_id NUMBER PRIMARY KEY,
    account_id NUMBER,
    amount NUMBER,
    transaction_date DATE
);

CREATE TABLE audit_log (
    log_id NUMBER PRIMARY KEY,
    table_name VARCHAR2(50),
    record_id NUMBER,
    action VARCHAR2(10),
    action_date DATE,
    user_name VARCHAR2(50)
);

CREATE SEQUENCE seq_audit_log START WITH 1;

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON transactions
FOR EACH ROW
BEGIN
    INSERT INTO audit_log (log_id, table_name, record_id, action, action_date, user_name)
    VALUES (seq_audit_log.NEXTVAL, 'Transactions', :NEW.transaction_id, 'INSERT', SYSDATE, USER);
    
    DBMS_OUTPUT.PUT_LINE('Transaction logged in audit: ' || :NEW.transaction_id);
END LogTransaction;
/

INSERT INTO transactions VALUES (1, 101, 500, SYSDATE);
INSERT INTO transactions VALUES (2, 102, 300, SYSDATE);

SELECT * FROM audit_log;
