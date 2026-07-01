package com.example;

import org.junit.*;
import static org.junit.Assert.*;

public class AAAPatternTest {
    
    private Calculator calculator;
    
    @Before
    public void setUp() {
        System.out.println("🔧 Setting up test environment...");
        calculator = new Calculator();
    }
    
    @After
    public void tearDown() {
        System.out.println("🧹 Cleaning up after test...");
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("🚀 Setting up test class (once)...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("🏁 Cleaning up test class (once)...");
    }
    
    @Test
    public void testAddWithAAA() {
        // ARRANGE
        int a = 7, b = 3;
        int expected = 10;
        
        // ACT
        int actual = calculator.add(a, b);
        
        // ASSERT
        assertEquals(expected, actual);
        System.out.println("✅ testAddWithAAA passed!");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZeroWithAAA() {
        // ARRANGE
        // ACT & ASSERT
        calculator.divide(10, 0);
        System.out.println("✅ testDivideByZeroWithAAA passed!");
    }
}
