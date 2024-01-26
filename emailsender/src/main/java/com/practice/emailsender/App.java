package com.practice.emailsender;

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

import java.net.Authenticator.RequestorType;
import java.net.InetAddress;

import java.net.URL;
import java.util.Properties;

import javax.mail.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("preparing to send message ...");
		String message = "Name:Spriyha,Semester:4th,Branch:MCA,Rollno:220231064 ";
		String subject ="Challenge 3 Completed";
		String to = " hr@ignitershub.com";
		String from = "meetspriyha13@gmail.com";
		
	    sendEmail(message,subject,to,from);
	    //sendAttach(message,subject,to,from);
		
    }

	private static void sendEmail(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
		String host="smtp.gmail.com";
		Properties prop=System.getProperties();
		System.out.println("PROPERTIES "+prop);
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port","465");
		prop.put("mail.smtp.ssl.enable","true");
		prop.put("mail.smtp.auth","true");
		
		Session session=Session.getInstance(prop,new Authenticator() {

			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("meetspriyha13@gmail.com","qobo bjeq ppir vjzt");
			}

			
			
		});
		session.setDebug(true);
        MimeMessage m = new MimeMessage(session);
		
		try {
		
		
		m.setFrom(from);
		
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		

		m.setSubject(subject);
	
		

		m.setText(message);
		
	
		
	
		Transport.send(m);
		
		System.out.println("Sent success...................");
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	private static void sendAttach(String message, String subject, String to, String from) {

		//Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("mauryas00113@gmail.com", "******");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		
		m.setFrom(from);
		
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		
		m.setSubject(subject);
	
		
		
		String path="D:\\image.jpg";
		
		
		MimeMultipart mimeMultipart = new MimeMultipart();
		
		
		MimeBodyPart textMime = new MimeBodyPart();
		
		MimeBodyPart fileMime = new MimeBodyPart();
		
		try {
			
			textMime.setText(message);
			
			File file=new File(path);
			fileMime.attachFile(file);
			
			
			mimeMultipart.addBodyPart(textMime);
			mimeMultipart.addBodyPart(fileMime);
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		m.setContent(mimeMultipart);
		
		
		
		Transport.send(m);
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	
		System.out.println("Sent success...................");
		
		
	}
}
