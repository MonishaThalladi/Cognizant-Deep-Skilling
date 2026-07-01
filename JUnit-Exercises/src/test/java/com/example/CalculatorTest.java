package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    private Calculator calculator = new Calculator();
    
    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        System.out.println("✅ testAdd passed!");
    }
    
    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        System.out.println("✅ testSubtract passed!");
    }
    
    @Test
    public void testMultiply() {
        assertEquals(12, calculator.multiply(4, 3));
        System.out.println("✅ testMultiply passed!");
    }
    
    @Test
    public void testDivide() {
        assertEquals(5, calculator.divide(10, 2));
        System.out.println("✅ testDivide passed!");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
        System.out.println("✅ testDivideByZero passed!");
    }
}
