package com.dw.lib;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.util.MimeMessageParser;
import org.apache.commons.mail.util.MimeMessageUtils;

public class EmailService {

	public void emlToHtml(String emlFilePath) {
		FileUtils fileUtils = new FileUtils();
		File file = new File(fileUtils.normalizePath(emlFilePath));
		
		try {
			MimeMessage mimeMessage = MimeMessageUtils.createMimeMessage(null, file);
			MimeMessageParser parser = new MimeMessageParser(mimeMessage);
			System.out.println("Email From: " + parser.getFrom());
			System.out.println("Email Subject: " + parser.getSubject());
			System.out.println("Email To: " + parser.getTo());

			List<DataSource> attachments = parser.parse().getAttachmentList();
			String folder = file.getAbsolutePath();
			for (DataSource ds : attachments) {
				String fileName = folder + File.separator + ds.getName();
				fileUtils.streamToFile(ds.getInputStream(), fileName);
				System.out.println("attachment:" + fileName);
			}

			fileUtils.stringToFile(parser.parse().getHtmlContent(), folder + File.separator + file.getName() + ".html");
		} catch (MessagingException e) {
			e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
