package com.dw.lib;

import java.time.LocalDateTime;

public class TimeStringToDate {
	//2017-03-30T12:00:00.000Z
	
	public static void main(String[] args) {
		String strTime = "2017-03-30T12:00:00.000";
			
		LocalDateTime dt = LocalDateTime.parse(strTime);
		
		System.out.println(String.format("%s-%s-%s", dt.getDayOfMonth(), dt.getMonthValue(), dt.getYear()));
	}
}
