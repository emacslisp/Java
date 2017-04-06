package com.dw.lib.test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.tidy.Tidy;

public class jtidyTest {

	public static final void prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		System.out.println(out.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tidy tidy = new Tidy();
		tidy.setQuiet(true);
		tidy.setShowWarnings(false);
		tidy.setShowErrors(0);
		tidy.setMakeClean(true);
		try {
			String search = "stub";
			URL urlObj = new URL("http://www.dict.org/bin/Dict?Form=Dict1&Query=" + search + "&Strategy=*&Database=*");
			URLConnection con = urlObj.openConnection();

			con.setDoOutput(true); // we want the response
			con.setRequestProperty("Cookie", "myCookie=test123");
			con.connect();
			Document document = tidy.parseDOM(con.getInputStream(), null);

			Node e = document.getElementsByTagName("form").item(0);

			e.getParentNode().removeChild(e);

			document.normalize();
			prettyPrint(document);
			// System.out.println(document.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
