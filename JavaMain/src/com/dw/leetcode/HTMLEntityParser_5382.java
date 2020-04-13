package com.dw.leetcode;

import java.util.HashMap;

public class HTMLEntityParser_5382 {
    public String entityParser(String text) {
    	HashMap<String, String> map = new HashMap<String, String>();
    	
    	map.put("&quot;", "\"");
    	map.put("&apos;", "'");
    	map.put("&amp;", "&");
    	map.put("&gt;", ">");
    	map.put("&lt;", "<");
    	map.put("&frasl;", "/");
    	
    	for(String k: map.keySet()) {
    		text = text.replace(k, map.get(k));
    	}
    	
    	return text;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HTMLEntityParser_5382 s= new HTMLEntityParser_5382();
		String text = "and I quote: &quot;...&quot;";
		System.out.println(s.entityParser(text));
	}

}
