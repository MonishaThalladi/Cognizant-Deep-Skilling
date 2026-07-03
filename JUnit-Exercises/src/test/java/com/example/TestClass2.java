package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestClass2 {
    
    @Test
    void testMethod3() {
        assertNotNull(new Object());
        System.out.println("✅ TestClass2 - testMethod3 passed!");
    }
    
    @Test
    void testMethod4() {
        assertNull(null);
        System.out.println("✅ TestClass2 - testMethod4 passed!");
    }
}
