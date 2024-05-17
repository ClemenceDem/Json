package com.adesso.insurance.maven;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAppLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(MyAppLogger.class);

    public static void main(String[] args) {
        // Example log messages
        logger.error("Error log message");
        logger.warn("Warning log message");
        logger.info("Info log message");
        logger.debug("Debug log message");
        logger.trace("Trace log message");
    }
}
