package com.dw.lib.cli;

import java.io.IOException;

import com.dw.lib.JavaXMLIndent;

public class XMLCLI {
	public static void main(String[] args) {
		JavaXMLIndent xmlIndent = new JavaXMLIndent();
		//String formattedJson1="";
		
		if(args.length != 1) {
			System.out.println("xml <input file>");
			return;
		}
		
		try {
			xmlIndent.FormatXML(args[0],args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
