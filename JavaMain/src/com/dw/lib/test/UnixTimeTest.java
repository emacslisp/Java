package com.dw.lib.test;

import com.dw.lib.DateTimeHelper;

public class UnixTimeTest {

	public static void main(String[] args) {
		try {
			int[] array = new int[6];
			
			for(int i=0;i<6;i++) {
				array[i] = 0;
			}
			
			array[0] = 2019;
			array[1] = 4;
			array[2] = 16;
			array[3] = 10;
			array[4] = 0;
			array[5] = 0;
			
			DateTimeHelper dateTimeHelper = new DateTimeHelper();
			long unixTime = dateTimeHelper.ConvertDateToUnixTime(array[0], array[1], array[2], array[3], array[4], array[5]);
			System.out.println(unixTime);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
