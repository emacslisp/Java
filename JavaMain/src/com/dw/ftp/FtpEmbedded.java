package com.dw.ftp;

import java.io.IOException;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.usermanager.impl.BaseUser;

import junit.framework.Test;

/*
 * cd /Users/ewu/dev/java/JavaMain/bin
 * sudo java -cp .:/Users/ewu/dev/Java/JavaMain/third-party/ftpserver-core-1.1.1-SNAPSHOT.jar:/Users/ewu/dev/Java/JavaMain/third-party/ftplet-api-1.1.1-SNAPSHOT.jar:/Users/ewu/dev/Java/JavaMain/third-party/mina-core-2.0.16.jar:/Users/ewu/dev/Java/JavaMain/third-party/slf4j-log4j12-1.7.21.jar:/Users/ewu/dev/Java/JavaMain/third-party/slf4j-api-1.7.21.jar:/Users/ewu/dev/Java/JavaMain/third-party/log4j-1.2.17.jar com.dw.ftp.FtpEmbedded
 */

public class FtpEmbedded {

	public static void main(String[] args) throws FtpException
	{
		// TODO Auto-generated method stub
		FtpServerFactory serverFactory = new FtpServerFactory();
		BaseUser user = new BaseUser();
	    user.setName("ftp");
	    user.setPassword("123456");
	    serverFactory.getUserManager().save(user);
		FtpServer server = serverFactory.createServer();
		// start the server
		try {
			System.out.println("ftp server started....");
			server.start();
		} catch (FtpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
