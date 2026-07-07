CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    interest_rate NUMBER
);

INSERT INTO loans VALUES (1, 101, 5.0);
INSERT INTO loans VALUES (2, 102, 4.5);
INSERT INTO loans VALUES (3, 103, 6.0);

DECLARE
    CURSOR cur_loans IS
        SELECT loan_id, interest_rate FROM loans;
    
    v_new_rate NUMBER;
BEGIN
    FOR loan_rec IN cur_loans LOOP
        v_new_rate := loan_rec.interest_rate - 0.5;
        
        IF v_new_rate < 2 THEN
            v_new_rate := 2;
        END IF;
        
        UPDATE loans
        SET interest_rate = v_new_rate
        WHERE loan_id = loan_rec.loan_id;
        
        DBMS_OUTPUT.PUT_LINE('Loan ' || loan_rec.loan_id || 
                             ' | Old Rate: ' || loan_rec.interest_rate || 
                             '% | New Rate: ' || v_new_rate || '%');
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('All loan interest rates updated.');
END;
/

SELECT * FROM loans;
