-- EXERCISE 1, SCENARIO 1: Apply 1% discount to customers above 60

CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    dob DATE,
    balance NUMBER,
    last_modified DATE
);

INSERT INTO customers VALUES (1, 'John Doe', TO_DATE('1950-05-15', 'YYYY-MM-DD'), 5000, SYSDATE);
INSERT INTO customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 3000, SYSDATE);
INSERT INTO customers VALUES (3, 'Bob Johnson', TO_DATE('1960-03-10', 'YYYY-MM-DD'), 10000, SYSDATE);
INSERT INTO customers VALUES (4, 'Alice Brown', TO_DATE('1945-11-25', 'YYYY-MM-DD'), 7000, SYSDATE);

DECLARE
    v_age NUMBER;
    v_discount_rate NUMBER := 0.01;
    v_customer_count NUMBER := 0;
BEGIN
    FOR customer_rec IN (SELECT customer_id, name, dob FROM customers) LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, customer_rec.dob) / 12);
        
        IF v_age > 60 THEN
            UPDATE customers
            SET balance = balance * (1 - v_discount_rate)
            WHERE customer_id = customer_rec.customer_id;
            
            v_customer_count := v_customer_count + 1;
            DBMS_OUTPUT.PUT_LINE('✅ Applied discount to: ' || customer_rec.name || 
                                 ' (Age: ' || v_age || ')');
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('📊 Discount applied to ' || v_customer_count || ' customers.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
END;
/

SELECT * FROM customers;
