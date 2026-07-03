package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {
    
    private PerformanceTester tester = new PerformanceTester();
    
    // Test 1: Timeout after 3 seconds (should pass)
    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    void testPerformTask() {
        tester.performTask();
        System.out.println("✅ performTask completed within 3 seconds!");
    }
    
    // Test 2: Timeout after 10 seconds (should pass)
    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testPerformLongTask() {
        tester.performLongTask();
        System.out.println("✅ performLongTask completed within 10 seconds!");
    }
    
    // Test 3: Timeout after 100 milliseconds (should fail)
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testPerformTaskFails() {
        // This test will fail because performTask() takes ~1.5 seconds
        tester.performTask();
        System.out.println("⏰ This should not print - test should timeout!");
    }
    
    // Test 4: Fast task with timeout (should pass quickly)
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testPerformFastTask() {
        tester.performFastTask();
        System.out.println("✅ performFastTask completed quickly!");
    }
}
