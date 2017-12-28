package com.dw.leetcode;

// Leetcode 729. My Calendar I https://leetcode.com/problems/my-calendar-i/description/
public class MyCalendarI {
	
	/*
	 * 
	 * ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
	 */
	
    public static void main(String[] args) {
    	MyCalendar obj = new MyCalendar();
    	
    	System.out.println(obj.book(47, 50));
    	System.out.println(obj.book(33, 41));
    	System.out.println(obj.book(39, 45));
    	System.out.println(obj.book(33, 42));
    	System.out.println(obj.book(25, 32));
    	System.out.println(obj.book(26, 35));
    	System.out.println(obj.book(19, 25));
    	System.out.println(obj.book(3, 8));
    	System.out.println(obj.book(8, 13));
    	System.out.println(obj.book(18, 27));
    }

}
