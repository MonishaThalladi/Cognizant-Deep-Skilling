package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestClass1 {
    
    @Test
    void testMethod1() {
        assertTrue(true);
        System.out.println("✅ TestClass1 - testMethod1 passed!");
    }
    
    @Test
    void testMethod2() {
        assertEquals(5, 2 + 3);
        System.out.println("✅ TestClass1 - testMethod2 passed!");
    }
}
