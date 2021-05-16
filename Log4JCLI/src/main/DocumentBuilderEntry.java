package main;

import java.io.*;
import java.net.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DocumentBuilderEntry {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = DocumentBuilderEntry.class.getResource("log4j.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			URLConnection uConn = url.openConnection();
			
			uConn.setUseCaches(false);
			InputStream stream = uConn.getInputStream();
			try {
			  InputSource src = new InputSource(stream);
			  src.setSystemId(url.toString());
			  Document doc = parser.parse(src);
			  
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			  stream.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

}
