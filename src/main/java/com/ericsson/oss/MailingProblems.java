package com.ericsson.oss;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;

import com.ericsson.oss.entites.OssProblems;
import com.ericsson.oss.services.IOssProblemsService;



public class MailingProblems  {
	
	public void SendMail (Long Id,float Capacity,String FileSystem, File file,List<OssProblems> ossproblemssolutions,String Problem,String Command,Session session) {

		try {
			String messagetext="";
			if (Command=="df -kh") {
				messagetext="<p>Dear user,</p> <p><strong> Problem name : </strong>"+Problem+"</p> <p><strong>Problem id:</strong> "
				+Id+"</p><p>The capacity of the File System : <strong>"+ FileSystem +"</strong> is equal to: <strong>"+Capacity+"</strong></p>";
				messagetext=messagetext+"<p>Proposed solutions:</p>";
			}
			ArrayList<String> Solution= new ArrayList<String>();
			for(OssProblems hadsolution :ossproblemssolutions)  {
				Solution.add(hadsolution.getProposed_solution());
			}
			int Null=0;
			for (int k=0;k<Solution.size();k++) 
				if (Solution.get(k) != null) {
					messagetext=messagetext+"<p>"+Solution.get(k)+"</p>";
				}else {
					Null++;
				}
			if(Null==Solution.size()) {
				messagetext=messagetext+"</p>No solutions are proposed at the moment for the problem Id : "+Id;
			}else {
				messagetext=messagetext+"<p> for the problem Id : "+Id;
			}
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("OSS.Problems@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("s.saoudi09@gmail.com"));
			message.setSubject(Problem);
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(messagetext,"text/html; charset=utf-8");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(file.getPath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(file.getPath());
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			
		}catch (MessagingException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public void SendMailVxdisk (Long Id,String Status,String Disk, File file,List<OssProblems> ossproblemssolutions,String Problem,Session session) {

		try {
			String messagetext="<p>Dear user,</p> <p><strong> Problem name : </strong>"+Problem+"</p> <p><strong>Problem id:</strong> "
				+Id+"</p><p>The status of the disk : <strong>"+ Disk +"</strong> is : <strong>"+Status+"</strong></p>";
				messagetext=messagetext+"<p>Proposed solutions:</p>";
			
			ArrayList<String> Solution= new ArrayList<String>();
			for(OssProblems hadsolution :ossproblemssolutions)  {
				Solution.add(hadsolution.getProposed_solution());
			}
			int Null=0;
			for (int k=0;k<Solution.size();k++) 
				if (Solution.get(k) != null) {
					messagetext=messagetext+"<p>"+Solution.get(k)+"</p>";
				}else {
					Null++;
				}
			if(Null==Solution.size()) {
				messagetext=messagetext+"</p>No solutions are proposed at the moment for the problem Id : "+Id;
			}else {
				messagetext=messagetext+"<p> for the problem Id : "+Id;
			}
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("OSS.Problems@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("s.saoudi09@gmail.com"));
			message.setSubject(Problem);
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(messagetext,"text/html; charset=utf-8");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(file.getPath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(file.getPath());
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			
		}catch (MessagingException e){
			throw new RuntimeException(e);
		}
		
	}
	
}
