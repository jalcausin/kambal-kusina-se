package com.kambalkusina.servlet;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmail2 {
	
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		
		return String.format("%06d", number);
	}
	
	
	public boolean SendEmail2(User2 user2) {
		boolean test = false;
		
		String toEmail = user2.getEmail();
		String fromEmail = "kambalkusinaregister@gmail.com";
		String password = "Adminpass123";
		
		try {
			
			Properties pr = new Properties();	
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "465");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.socketFactory.port", "465");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			});
			
			Message mess = new MimeMessage(session);
			
			mess.setFrom(new InternetAddress(fromEmail));
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			
			mess.setSubject("Forgot Password Code");
			
			mess.setText("To change your password please enter this code: " +user2.getCode() );
			
			Transport.send(mess);
			
			test=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return test;
	}
	
}
