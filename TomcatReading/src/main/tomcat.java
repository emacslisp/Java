package main;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.util.Diagnostics;

public class tomcat {
	public static void main(String[] args) {
		// Diagnostics();
		
		getProperty();
	}
	
	public static void getProperty() {
		System.out.println(System.getProperty("user.dir"));
	}
	
	public static void Diagnostics() {
		Log log = LogFactory.getLog(tomcat.class);
		log.info("this is a info message from tomcat");
		log.debug("this is a debug message from tomcat");
		
		System.out.println(Diagnostics.getVMInfo());
	}

	
}
