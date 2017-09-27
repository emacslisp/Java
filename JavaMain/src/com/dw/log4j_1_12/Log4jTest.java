package com.dw.log4j_1_12;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jTest {
	static Logger logger = Logger.getLogger(Log4jTest.class);
	
    public static void main(String[] args) {
        //System.out.println("Test config");
    	
    	DOMConfigurator.configure("/Users/ewu/dev/Java/JavaMain/src/com/dw/log4j_1_12/log4j.xml");
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");
    }
}
