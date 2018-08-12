package com.dw.lib.test;

import java.util.UUID;

public class UUIDCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if (args.length == 0)
				System.out.println(UUID.randomUUID());

			for (String s : args) {
				System.out.println(UUID.fromString(s));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
