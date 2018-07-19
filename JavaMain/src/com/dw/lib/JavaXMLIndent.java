package com.dw.lib;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class JavaXMLIndent {

	public static String prettyFormat(String input) {
	    return prettyFormat(input, "2");
	}

	public static String prettyFormat(String input, String indent) {
	    Source xmlInput = new StreamSource(new StringReader(input));
	    StringWriter stringWriter = new StringWriter();
	    try {
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", indent);
	        transformer.transform(xmlInput, new StreamResult(stringWriter));

	        String pretty = stringWriter.toString();
	        pretty = pretty.replace("\r\n", "\n");
	        return pretty;              
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void FormatXML(String inputfile, String outputFile) throws IOException {
		FileUtils fileUtils = new FileUtils();
		fileUtils.stringToFile(prettyFormat(fileUtils.fileToString(inputfile)),outputFile);
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
