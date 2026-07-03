package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public void performTask(String taskName) {
        logger.info("Starting task: {}", taskName);
        try {
            Thread.sleep(500);
            logger.debug("Task completed: {}", taskName);
        } catch (InterruptedException e) {
            logger.error("Task interrupted: {}", taskName, e);
        }
    }

    public static void main(String[] args) {
        LoggingExample example = new LoggingExample();
        logger.info("=== Application Started ===");
        example.performTask("Data Processing");
        logger.info("=== Application Finished ===");
    }
}
