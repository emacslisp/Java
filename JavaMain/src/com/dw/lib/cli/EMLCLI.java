package com.dw.lib.cli;

import java.io.File;

import com.dw.lib.EmailService;

public class EMLCLI {
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("eml <file-path>");
			return;
		}
		
		try {
			
			File file = new File(args[0]);
			
			if (!file.exists()) {
				System.out.println("eml file is not existed");
				return;
			}
			
			EmailService emailService = new EmailService();
			
			emailService.emlToHtml(args[0]);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
