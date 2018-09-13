package com.dw.lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class JavaXMLIndent {

	public static void prettyFormat(String input, String output) {    
	    try {
	    	FileUtils f = new FileUtils();
	    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    	factory.setNamespaceAware(true);
	    	DocumentBuilder db = factory.newDocumentBuilder();
		    Document doc = db.parse( new InputSource( new StringReader( f.fileToString(input) ) ) ); 
		    DOMSource source = new DOMSource(doc);
		    
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        transformerFactory.setAttribute("indent-number", new Integer(2));
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"yes");
	        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	        
	        File file = new File(output); 
	        if(!file.exists()){ 
	            file.createNewFile(); 
	        } 
	        
	        FileOutputStream out1 = new FileOutputStream(file); 
	         
	        StreamResult xmlResult = new StreamResult(out1); 
	      
	        transformer.transform(source, xmlResult); 
            
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void FormatXML(String inputfile, String outputFile) throws IOException {
		// FileUtils fileUtils = new FileUtils();
		prettyFormat(inputfile ,outputFile);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		JavaXMLIndent xmlIndent = new JavaXMLIndent();
		//String formattedJson1="";
		try {
			xmlIndent.FormatXML("/Users/di.wu/test/1.xml", "/Users/di.wu/test/2.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
