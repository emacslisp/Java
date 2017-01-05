package com.dw.lib;

import java.time.*;

public class CurrentDateTime {

	//@example: 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate dNow = LocalDate.now();
		System.out.println(dNow);
		LocalTime tNow = LocalTime.now();
		System.out.println(tNow);
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
	}

}
