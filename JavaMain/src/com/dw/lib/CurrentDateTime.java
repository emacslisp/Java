package com.dw.lib;

import java.time.*;

public class CurrentDateTime {

	//@example: Java - java.time.* - Local Date
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
