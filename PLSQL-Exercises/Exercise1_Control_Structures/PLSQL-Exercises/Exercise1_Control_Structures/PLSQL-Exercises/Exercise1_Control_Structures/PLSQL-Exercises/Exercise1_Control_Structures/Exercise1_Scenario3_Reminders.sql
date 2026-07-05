CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    loan_amount NUMBER,
    interest_rate NUMBER,
    start_date DATE,
    end_date DATE
);

INSERT INTO loans VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 30));
INSERT INTO loans VALUES (2, 2, 15000, 4.5, SYSDATE, ADD_MONTHS(SYSDATE, 20));
INSERT INTO loans VALUES (3, 3, 10000, 6, SYSDATE, ADD_MONTHS(SYSDATE, 25));
INSERT INTO loans VALUES (4, 4, 20000, 3.5, SYSDATE, ADD_MONTHS(SYSDATE, 45));

DECLARE
    v_days_until_due NUMBER;
    v_count NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== LOAN REMINDERS (Due in 30 days) ===');
    
    FOR loan_rec IN (SELECT l.*, c.name 
                     FROM loans l
                     JOIN customers c ON l.customer_id = c.customer_id
                     WHERE end_date BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        
        v_days_until_due := FLOOR(loan_rec.end_date - SYSDATE);
        v_count := v_count + 1;
        
        DBMS_OUTPUT.PUT_LINE('Reminder #' || v_count);
        DBMS_OUTPUT.PUT_LINE('Customer: ' || loan_rec.name);
        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || loan_rec.loan_id);
        DBMS_OUTPUT.PUT_LINE('Amount: $' || loan_rec.loan_amount);
        DBMS_OUTPUT.PUT_LINE('Due in: ' || v_days_until_due || ' days');
        DBMS_OUTPUT.PUT_LINE('Due Date: ' || TO_CHAR(loan_rec.end_date, 'DD-MON-YYYY'));
        DBMS_OUTPUT.PUT_LINE('---');
    END LOOP;
    
    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due in the next 30 days.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Total reminders sent: ' || v_count);
    END IF;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

SELECT * FROM loans;
