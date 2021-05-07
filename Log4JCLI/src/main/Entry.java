package main;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Entry {
	static Logger logger = Logger.getLogger(Entry.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOMConfigurator.configure(Entry.class.getResource("log4j.xml"));
		logger.debug("This is messaging");
	}

}
