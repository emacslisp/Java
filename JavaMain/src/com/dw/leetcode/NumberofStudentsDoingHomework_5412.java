package com.dw.leetcode;

// https://leetcode.com/contest/weekly-contest-189/problems/number-of-students-doing-homework-at-a-given-time/
public class NumberofStudentsDoingHomework_5412 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        
        for(int i=0;i<startTime.length;i++) {
        	if(startTime[i]<=queryTime && queryTime<=endTime[i]) {
        		result++;
        	}
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[] startTime = {4};
	int[] endTime = {4};
	int queryTime = 4;
	
	NumberofStudentsDoingHomework_5412 s = new NumberofStudentsDoingHomework_5412();

	System.out.println(s.busyStudent(startTime, endTime, queryTime));
	}

}
