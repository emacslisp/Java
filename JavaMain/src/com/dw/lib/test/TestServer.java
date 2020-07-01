package com.dw.lib.test;

import java.io.*;
import java.net.*;

import com.dw.lib.SocketHelper;

public class TestServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = SocketHelper.CreateTcpListener(6666);
			while(true) {
				Socket s = SocketHelper.StartServerSocket(ss);// establishes connection
				String output = SocketHelper.ReadAsString(s);
				System.out.println("Message: " + output);
				SocketHelper.close(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
