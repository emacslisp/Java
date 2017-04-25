package com.dw.leetcode;

import java.util.HashMap;

//@example: Leetcode - 551. Student_Attendance_Record_I - https://leetcode.com/problems/student-attendance-record-i/#/description
public class Student_Attendance_Record_I_551 {
	
	public static boolean checkRecord(String s) {
        
        int a = 0,l=0;
        
        for(int i=0;i<s.length();i++) {
        	
        	char c = s.charAt(i);
        	
        	if(c == 'A'){
        		a++;
        		l=0;
        	}
        	
        	if(a >= 2) return false;
        	
        	if(c == 'L')
        	{
        		l++;
        		
        	}
        	
        	if(l >= 3) return false;
        	
        	if( c!='A' && c!='L') {
        		l=0;
        	}
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(checkRecord("PPLALL"));
		
	}

}
