package com.example;

import java.util.concurrent.TimeUnit;

public class PerformanceTester {
    
    public void performTask() {
        try {
            // Simulate a task that takes 1-2 seconds
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void performFastTask() {
        // Fast task - no delay
    }
    
    public void performLongTask() {
        try {
            // Simulate a task that takes 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
