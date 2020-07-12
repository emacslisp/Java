package com.dw.leetcode;
import java.util.*;
public class ReformatDate_1507 {
	public String reformatDate(String date) {
        HashMap<String, Integer> days = new HashMap<String, Integer>();
        HashMap<String, Integer> months = new HashMap<String, Integer>();
        
        String[] daysArray = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th","30th", "31st"};
        String[] monthArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        int counter = 1;
        for(String day : daysArray) {
        	days.put(day, counter++);
        }
        
        counter = 1;
        
        for(String month: monthArray) {
        	months.put(month, counter++);
        }
        
        String[] dateArray = date.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(dateArray[2]);
        sb.append("-");
        int m = months.get(dateArray[1]);
        int d = days.get(dateArray[0]);
        
        if(m < 10) {
        	sb.append("0" + m);
        } else {
        	sb.append(m);
        }
        sb.append("-");
        if(d < 10) {
        	sb.append("0" + d);
        } else {
        	sb.append(d);
        }
        
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReformatDate_1507 s= new ReformatDate_1507();
		String date = "20th Oct 2052";
		System.out.println(s.reformatDate(date));
	}

}
