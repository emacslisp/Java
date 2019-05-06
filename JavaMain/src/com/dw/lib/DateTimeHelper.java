package com.dw.lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.GregorianCalendar;

public class DateTimeHelper {
	
	public Date ConvertDateToUnixTime(int year, int month, int day, int hour, int minutes, int seconds) {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, minutes, seconds);
		Date date = calendar.getTime();
		return date;
	}
	
	public Date ConvertUnixTimeToDate(long unixTime) {
		Date date = new Date(unixTime);
		return date;
	}

	public static void main(String[] args) {
		String sDate1="31/12/1998";  
	    Date date1;
	    DateTimeHelper dateTimeHelper = new DateTimeHelper();
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			System.out.println(sDate1+"\t"+date1); 
			System.out.println(date1.getTime());
			
			// test UnixTime
			long unixTime = 1554382800000l;
			Date dateUnixTime = dateTimeHelper.ConvertUnixTimeToDate(unixTime);
			System.out.println(dateUnixTime.toString());
			System.out.println(dateUnixTime.toInstant().toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
