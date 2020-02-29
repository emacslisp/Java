package com.dw.leetcode;

public class NumberOfDaysBetweenTwoDates_1360 {

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
	
	public boolean isLeap(int year) {
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
	
	boolean min(int[] date1Num, int[] date2Num) {
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
        	if( isLeap(i)) {
        		total += 366;
        	}
        	else {
        		total += 365;
        	}
        }
        
        
        if(isLeap(maxDate[0])) {
        	total += leapMonth[maxDate[1] - 1] + maxDate[2];
        }
        else {
        	total += month[maxDate[1] - 1] + maxDate[2];
        }
        
        if(isLeap(minDate[0])) {
        	total -= leapMonth[minDate[1] - 1] + minDate[2];
        }
        else {
        	total -= month[minDate[1] - 1] + minDate[2];
        }
        
        return total;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "2019-06-29", date2 = "2019-06-30"
		NumberOfDaysBetweenTwoDates_1360 s = new NumberOfDaysBetweenTwoDates_1360();
		
		int result = s.daysBetweenDates("2020-01-15", "2019-12-31");
		
		System.out.println(result);
	}

}
