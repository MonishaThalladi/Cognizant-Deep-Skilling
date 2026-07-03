package com.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {
    
    @Test
    @Order(1)
    void testFirst() {
        System.out.println("✅ 1. This test runs FIRST (Order 1)");
    }
    
    @Test
    @Order(2)
    void testSecond() {
        System.out.println("✅ 2. This test runs SECOND (Order 2)");
    }
    
    @Test
    @Order(3)
    void testThird() {
        System.out.println("✅ 3. This test runs THIRD (Order 3)");
    }
    
    @Test
    @Order(4)
    void testFourth() {
        System.out.println("✅ 4. This test runs FOURTH (Order 4)");
    }
    
    @Test
    @Order(5)
    void testFifth() {
        System.out.println("✅ 5. This test runs FIFTH (Order 5)");
    }
}
