package com.dw.lib.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * @todo: put log4j-api-2.8.2.jar debug version and log4j-core-2.8.2.jar debug version to replace release version
 * read source code of log4j 2
 */
public class Log4j2Test {
	private static final Logger logger = LogManager.getLogger(Log4j2Test.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.debug("Hello world - debug log");
		logger.info("Hello world - info log");
		logger.warn("Hello world - warn log");
		logger.error("Hello world - error log");
	}

}
