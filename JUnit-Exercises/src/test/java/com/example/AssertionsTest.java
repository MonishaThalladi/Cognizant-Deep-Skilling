package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    
    @Test
    public void testAssertions() {
        // assertEquals
        assertEquals("2 + 3 should equal 5", 5, 2 + 3);
        
        // assertTrue
        assertTrue("5 should be greater than 3", 5 > 3);
        
        // assertFalse
        assertFalse("5 should NOT be less than 3", 5 < 3);
        
        // assertNull
        String nullString = null;
        assertNull("Object should be null", nullString);
        
        // assertNotNull
        String notNullString = "Hello";
        assertNotNull("Object should NOT be null", notNullString);
        
        // assertArrayEquals
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals("Arrays should be equal", expected, actual);
        
        System.out.println("✅ All assertions passed!");
    }
}
