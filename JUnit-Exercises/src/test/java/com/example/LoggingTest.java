package com.example;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingTest {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);

    @Test
    void testLogging() {
        logger.trace("TRACE message");
        logger.debug("DEBUG message");
        logger.info("INFO message");
        logger.warn("WARN message");
        logger.error("ERROR message");
        logger.info("✅ LoggingTest passed!");
    }
}
