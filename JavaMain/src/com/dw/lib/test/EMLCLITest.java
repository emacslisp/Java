package com.dw.lib.test;

import org.apache.commons.mail.util.MimeMessageParser;
import org.apache.commons.mail.util.MimeMessageUtils;

import com.dw.lib.FileUtils;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class EMLCLITest {

	public static void main(String[] args) {
        File file = new File("/Users/ewu/Downloads/Mail_Attachment.eml");
        try {
            MimeMessage mimeMessage = MimeMessageUtils.createMimeMessage(null, file);
            MimeMessageParser parser = new MimeMessageParser(mimeMessage);
            System.out.println("Email From: "+parser.getFrom());
            System.out.println("Email Subject: "+parser.getSubject());
            System.out.println("Email To: "+parser.getTo());
                       
            FileUtils fileUtils = new FileUtils();
            List<DataSource> attachments = parser.parse().getAttachmentList();
            String folder = "/Users/ewu/Downloads";
            for(DataSource ds : attachments) {
            	String fileName = folder + File.separator + ds.getName();
            	fileUtils.streamToFile(ds.getInputStream(), fileName);
            	System.out.println("attachment:" + fileName);
            }
            
            fileUtils.stringToFile(parser.parse().getHtmlContent(), "/Users/ewu/Downloads/Mail_Attachment.html");
        } catch (MessagingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
	}

}
