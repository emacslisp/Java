package main;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class tomcat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Log log = LogFactory.getLog(tomcat.class);
		log.info("this is a info message from tomcat");
		log.debug("this is a debug message from tomcat");
	}
}
