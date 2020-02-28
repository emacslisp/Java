package com.dw.lib.cli;

import java.io.File;

import com.dw.lib.HexConverter;


public class HexCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1) {
			System.out.println("jhex <arg1>");
			return;
		}
		
		try {
			if(args.length == 1) {
				int input = Integer.parseInt(args[0]);
				HexConverter converter = new HexConverter();
				
				System.out.println("Binary: " + converter.decHex(input, 2));
				System.out.println("Oct: " + converter.decHex(input, 8));
				System.out.println("Hex: " + converter.decHex(input, 16));
			}
			
			if(args.length == 2) {
				// @todo : base to int
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
