package com.dw.lib.cli;

import java.io.File;
import java.util.Date;

import com.dw.lib.DateTimeHelper;
import com.dw.lib.FileUtils;

public class UnixTimeCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length > 6 || args.length < 3) {
			System.out.println("unixtime <year> <month> <day> <hour> <minute> <second>");
			return;
		}
		
		try {
			int[] array = new int[6];
			
			for(int i=0;i<6;i++) {
				array[i] = 0;
			}
			
			for(int i=0;i<args.length;i++) {
				array[i] = Integer.parseInt(args[i]);
			}
			
			DateTimeHelper dateTimeHelper = new DateTimeHelper();
			Date dateTime = dateTimeHelper.ConvertDateToUnixTime(array[0], array[1], array[2], array[3], array[4], array[5]);
			System.out.println(dateTime.toString());
			System.out.println(dateTime.toInstant().toString());
			System.out.println(dateTime.getTime());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
