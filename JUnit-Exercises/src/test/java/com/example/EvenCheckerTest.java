package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {
    
    private EvenChecker checker = new EvenChecker();
    
    // Parameterized Test - tests multiple values
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 100, 0})
    void testEvenNumbers(int number) {
        assertTrue(checker.isEven(number), number + " should be even");
        System.out.println("✅ " + number + " is even - test passed!");
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 99, -1})
    void testOddNumbers(int number) {
        assertFalse(checker.isEven(number), number + " should be odd");
        System.out.println("✅ " + number + " is odd - test passed!");
    }
    
    // Regular test for single value
    @Test
    void testIsEvenWithZero() {
        assertTrue(checker.isEven(0));
        System.out.println("✅ 0 is even - test passed!");
    }
}
