-- EXERCISE 1, SCENARIO 2: Promote VIP Customers (Balance > 10000)

-- Step 1: Add VIP column
ALTER TABLE customers ADD is_vip CHAR(1) DEFAULT 'N';

-- Step 2: PL/SQL Block to update VIP status
DECLARE
    v_is_vip CHAR(1);
    v_count NUMBER := 0;
BEGIN
    FOR customer_rec IN (SELECT customer_id, name, balance FROM customers) LOOP
        IF customer_rec.balance > 10000 THEN
            v_is_vip := 'Y';
            v_count := v_count + 1;
        ELSE
            v_is_vip := 'N';
        END IF;
        
        UPDATE customers
        SET is_vip = v_is_vip
        WHERE customer_id = customer_rec.customer_id;
        
        DBMS_OUTPUT.PUT_LINE('👤 Customer: ' || customer_rec.name || 
                             ' | Balance: $' || customer_rec.balance || 
                             ' | VIP: ' || v_is_vip);
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('📊 ' || v_count || ' customers promoted to VIP.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
END;
/

-- Step 3: Check results
SELECT * FROM customers;
