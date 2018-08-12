package com.dw.lib.test;

import java.io.IOException;

import com.dw.lib.JsonOp;

public class JsonOpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonOp jsonOp = new JsonOp();
		
		if(args.length != 1) {
			System.out.println("json <input file>");
			return;
		}
		
		try {
			jsonOp.FormatJson(args[0], args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
