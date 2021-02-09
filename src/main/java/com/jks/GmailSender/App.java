package com.jks.GmailSender;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Preparing mail......" );
        String message="Hello ,This is mail for java opening for TCS";
        String subject="Singh Group";
        String to="abc@gmail.com";
        String from="jitendrakm.02@gmail.com";
        
        sendEmail(message,subject,to,from);
        sendAttachment(message,subject,to,from);
       
    }

	private static void sendAttachment(String message, String subject, String to, String from) {
		
		String host="smtp.gmail.com";
		Properties properties = System.getProperties();
		System.out.println("Properties : "+properties);
		
		//Host setting
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//session object 
	    Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("jitendrakm.02@gmail.com","xyzzzz");
			}
			
		});
		//debug session
	    session.setDebug(true);
	    
	    //compose to message
	    
	     MimeMessage mimeMessage = new MimeMessage(session);
		
	     try {
				//from email to send mail
			   mimeMessage.setFrom();
			 //adding recipient email to send mail
			   mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			   
			   //adding subject to email
			   mimeMessage.setSubject(subject);
			   //adding test to message
			   //mimeMessage.setText(message);
			   
			   //file path
			   String path="C:\\Users\\lenovo\\Downloads\\Jitendra.pdf";
			   MimeMultipart mimeMultipart = new MimeMultipart();
			   //text
			   MimeBodyPart textMime=new MimeBodyPart();
			   //file
			   MimeBodyPart fileMime=new MimeBodyPart();
			   try {
				   textMime.setText(message);
				   File file=new File(path);
				   fileMime.attachFile(file);
				   
				   mimeMultipart.addBodyPart(textMime);
				   mimeMultipart.addBodyPart(fileMime);
				   
				   
				   
			   }catch(Exception e) {
				   e.printStackTrace();
			   }
			   mimeMessage.setContent(mimeMultipart);
			   //send email by transport class
			  
			   Transport.send(mimeMessage);
			   System.out.println("Email sent successfully");
			
			}catch(Exception e) {
				e.printStackTrace();
			}

		
	}

	private static void sendEmail(String message, String subject, String to, String from) {
		
		String host="smtp.gmail.com";
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES : "+properties);
		
		//host set
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//to get the seesion object
		
		Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("jitendrakm.02@gmail.com","xyzzzzz");
			}
			
		});
		session.setDebug(true);
		//compose the message
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			//from email to send mail
		   mimeMessage.setFrom();
		 //adding recipient email to send mail
		   mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		   
		   //adding subject to email
		   mimeMessage.setSubject(subject);
		   //adding test to message
		   mimeMessage.setText(message);
		   
		   //send email by transport class
		   
		   Transport.send(mimeMessage);
		   System.out.println("Email sent successfully");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
