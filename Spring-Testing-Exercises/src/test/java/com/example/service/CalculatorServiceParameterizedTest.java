package com.example.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceParameterizedTest {

    private CalculatorService service = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "-1, 1, 0",
        "0, 0, 0",
        "10, -5, 5",
        "-5, -5, -10"
    })
    void testAddMultipleInputs(int a, int b, int expected) {
        assertEquals(expected, service.add(a, b));
        System.out.println("✅ " + a + " + " + b + " = " + expected);
    }
}
