package com.dw.lib.test;

import java.io.IOException;

import com.dw.lib.JsonOp;

public class JsonOpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonOp jsonOp = new JsonOp();
		
		try {
			jsonOp.FormatJson("/Users/ewu/test/1.json", "/Users/ewu/test/2.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
