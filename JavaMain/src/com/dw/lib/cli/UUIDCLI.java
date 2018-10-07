package com.dw.lib.cli;

import java.util.UUID;

public class UUIDCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if (args.length > 0){
				System.out.println("UUID didn't take any arguements");
				return;
			}
			
			System.out.println(UUID.randomUUID());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
