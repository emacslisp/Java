package com.dw.lib.test;
import java.io.*;
import java.net.*;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{      
			Socket s=new Socket("localhost",6666);  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			dout.writeUTF("Hello Server");  
			dout.flush();  
			dout.close();  
			s.close();  
			}catch(Exception e){System.out.println(e);}  
	}

}
