package com.dw.lib.test;
import java.io.*;
import java.net.*;

import com.dw.lib.SocketHelper;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = SocketHelper.CreateClientListner("localhost", 6666);
			SocketHelper.Send(socket, "Transfer via Socket");
			SocketHelper.close(socket);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
