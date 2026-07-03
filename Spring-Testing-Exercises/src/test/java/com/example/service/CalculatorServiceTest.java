package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService service = new CalculatorService();
        assertEquals(5, service.add(2, 3));
        assertEquals(0, service.add(-1, 1));
        assertEquals(-5, service.add(-2, -3));
        System.out.println("✅ Exercise 1: CalculatorServiceTest passed!");
    }
}
