CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_months NUMBER;
    v_installment NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / 100 / 12;
    v_months := p_years * 12;
    
    v_installment := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months) / 
                     (POWER(1 + v_monthly_rate, v_months) - 1);
    
    RETURN ROUND(v_installment, 2);
END CalculateMonthlyInstallment;
/

DECLARE
    v_installment NUMBER;
BEGIN
    v_installment := CalculateMonthlyInstallment(5000, 5, 5);
    DBMS_OUTPUT.PUT_LINE('Monthly Installment: $' || v_installment);
END;
/

SELECT CalculateMonthlyInstallment(5000, 5, 5) AS Monthly_Installment FROM DUAL;
