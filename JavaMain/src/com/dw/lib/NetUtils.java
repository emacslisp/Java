package com.dw.lib;

import java.io.IOException;
import java.net.InetAddress;

public class NetUtils {
	public static void ping(String host) {
		String ipAddress = "127.0.0.1";
		InetAddress inet;
		try {
			/*
			inet = InetAddress.getByName(ipAddress);

			System.out.println("Sending Ping Request to " + ipAddress);
			System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");*/

			//ipAddress = "173.194.32.38";
			inet = InetAddress.getByName(host);

			System.out.println("Sending Ping Request to " + ipAddress);
			System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
