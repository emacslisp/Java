package com.dw.lib;
	

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketHelper {
	
	public static boolean Send(Socket socket, String sMessage) {
		byte[] abMessage = sMessage.getBytes();
		return Send(socket, abMessage);
	}
	
	public static boolean Send(Socket socket, byte[] abMessage) {
		return Send(socket, abMessage, 0, abMessage.length);
	}
	
	public static boolean Send(Socket socket, byte[] abMessage, int nStart) {
		return Send(socket, abMessage, nStart, abMessage.length - nStart);
	}
	
	public static boolean Send(Socket socket, byte [] abMessage, int nStart, int nLength)
	{
		boolean fReturn = true;
		
		try {
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(abMessage, nStart, nLength);
			outputStream.flush();
		} catch(Exception e) {
			
		}
		
		return fReturn;
		
	}
	public static Socket CreateClientListner(String sAddress, int nPort) {
		Socket clientSocket = null;
		
		try
		{
			clientSocket = new Socket(sAddress, nPort);
		}
		catch (Exception e)
		{
			clientSocket = null;
		}
		
		return clientSocket;
	}
	
	public static ServerSocket CreateTcpListener(int nPort)
	{
		ServerSocket serverSocket = null;

		try
		{
			serverSocket = new ServerSocket(nPort);
		}
		catch (Exception e)
		{
			serverSocket = null;
		}

		return serverSocket;
	}
	
	public static String ReadAsString(Socket s) {

		try {
			BufferedReader reader = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
			String str = reader.readLine();
			return str;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Socket StartServerSocket(ServerSocket ss) {
		
		if(ss == null) return null;
		
		try {
			System.out.println("Server start to listen at: " + ss.getLocalPort() + " " + ss.getInetAddress());
			Socket s = ss.accept();
			return s;
		} catch(Exception e) {
			
		}
		
		return null;
	}
	
	public static void close(Socket socket) {
		if(socket == null) {
			return;
		}
		
		try {
			socket.close();
		} catch(Exception e) {
			
		}
	}
	
}
