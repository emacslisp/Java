package org.spring.main;

import java.util.List;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class SpringMain {
	
	public void MultiValueMapEntry() {
		MultiValueMap<String, String> multiValueMaps = new LinkedMultiValueMap<String, String>();
		multiValueMaps.add("Tom", "Book");
		multiValueMaps.add("Tom", "Pen");
		
		multiValueMaps.add("ABC", "Company");
		multiValueMaps.add("ABC", "WebSite");
		
		for(String key: multiValueMaps.keySet()) {
			List<String> value = multiValueMaps.get(key);
			System.out.print(key + "\t");
			for(String s: value) {
				System.out.print(s + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringMain s = new SpringMain();
		s.MultiValueMapEntry();
	}

}
