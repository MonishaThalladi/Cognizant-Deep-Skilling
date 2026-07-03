package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {
    
    private ExceptionThrower thrower = new ExceptionThrower();
    
    // Test 1: Expecting IllegalArgumentException
    @Test
    void testThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
        System.out.println("✅ IllegalArgumentException caught!");
    }
    
    // Test 2: Expecting ArithmeticException
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            thrower.divide(10, 0);
        });
        System.out.println("✅ ArithmeticException caught!");
    }
    
    // Test 3: Verify exception message
    @Test
    void testExceptionMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
        assertEquals("This is a test exception!", exception.getMessage());
        System.out.println("✅ Exception message verified!");
    }
    
    // Test 4: No exception thrown
    @Test
    void testNoException() {
        assertDoesNotThrow(() -> {
            thrower.throwException(false);
        });
        System.out.println("✅ No exception thrown - test passed!");
    }
}
