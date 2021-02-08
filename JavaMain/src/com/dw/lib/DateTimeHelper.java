package com.dw.lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.GregorianCalendar;

public class DateTimeHelper {
	
	int DAY = 1;
	int leapMonth[] = {
			0,
			DAY*(31),
			DAY*(31+29),
			DAY*(31+29+31),
			DAY*(31+29+31+30),
			DAY*(31+29+31+30+31),
			DAY*(31+29+31+30+31+30),
			DAY*(31+29+31+30+31+30+31),
			DAY*(31+29+31+30+31+30+31+31),
			DAY*(31+29+31+30+31+30+31+31+30),
			DAY*(31+29+31+30+31+30+31+31+30+31),
			DAY*(31+29+31+30+31+30+31+31+30+31+30)
	};  
	
	int month[] = {
			0,
			DAY*(31),
			DAY*(31+28),
			DAY*(31+28+31),
			DAY*(31+28+31+30),
			DAY*(31+28+31+30+31),
			DAY*(31+28+31+30+31+30),
			DAY*(31+28+31+30+31+30+31),
			DAY*(31+28+31+30+31+30+31+31),
			DAY*(31+28+31+30+31+30+31+31+30),
			DAY*(31+28+31+30+31+30+31+31+30+31),
			DAY*(31+28+31+30+31+30+31+31+30+31+30)
	}; 
	
	public boolean isLeapYear(int year) {
		boolean leap = false;

        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                if ( year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }
        else
            leap = false;

       return leap;
	}
	
	private boolean min(int[] date1Num, int[] date2Num) {
		boolean result = false;
		
		for(int i=0;i<date1Num.length;i++) {
			if(date1Num[i] < date2Num[i]) {
				return true;
			} else if (date1Num[i] > date2Num[i]) {
				return false;
			}
		}
		return result;
	}
	
    public int daysBetweenDates(String date1, String date2) {
        String[] date1Array = date1.split("-");
        String[] date2Array = date2.split("-");
        int[] date1Num = new int[3];
        int[] date2Num = new int[3];
        
        for(int i=0;i<date1Array.length;i++) {
        	date1Num[i] = Integer.parseInt(date1Array[i]);
        }
        
        for(int i=0;i<date2Array.length;i++) {
        	date2Num[i] = Integer.parseInt(date2Array[i]);
        }
        
        int[] minDate;
        int[] maxDate;
        
        if(min(date1Num, date2Num)) {
        	minDate = date1Num;
        	maxDate = date2Num;
        }
        else {
        	minDate = date2Num;
        	maxDate = date1Num;
        }
        int total = 0;
        for(int i = minDate[0];i < maxDate[0];i++) {
        	if( isLeapYear(i)) {
        		total += 366;
        	}
        	else {
        		total += 365;
        	}
        }
        
        
        if(isLeapYear(maxDate[0])) {
        	total += leapMonth[maxDate[1] - 1] + maxDate[2];
        }
        else {
        	total += month[maxDate[1] - 1] + maxDate[2];
        }
        
        if(isLeapYear(minDate[0])) {
        	total -= leapMonth[minDate[1] - 1] + minDate[2];
        }
        else {
        	total -= month[minDate[1] - 1] + minDate[2];
        }
        
        return total;
    }
	
	
	public Date ConvertDateToUnixTime(int year, int month, int day, int hour, int minutes, int seconds) {
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, minutes, seconds);
		Date date = calendar.getTime();
		return date;
	}
	
	public Date ConvertUnixTimeToDate(long unixTime) {
		Date date = new Date(unixTime);
		return date;
	}
	
	public String daysOfWeek(int day, int month, int year) {
		int[] daysOfMonth = {
	        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	    };
	    String[] output = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    
	    int totalDays = 0;
	    for(int i=1970;i<year;i++) {
	        if(isLeapYear(i)) {
	            totalDays += 366;
	        } else {
	            totalDays += 365;
	        }
	    }

	    for(int i=1;i<month;i++) {
	        totalDays += daysOfMonth[i - 1];
	    }

	    if(month > 2 && isLeapYear(year)) {
	        totalDays += 1;
	    }

	    totalDays += day;

	    // 1970, 1 and 1 is Thursday
	    int offset = (3 + totalDays) % 7;
	    return output[offset];
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
			
			int result = dateTimeHelper.daysBetweenDates("2020-01-15", "2019-12-31");
			
			System.out.println(result);
			
			int day = 9;
			int month = 2;
			int year = 2021;
			System.out.println(dateTimeHelper.daysOfWeek(day, month, year));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
