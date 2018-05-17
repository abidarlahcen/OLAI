package com.ericsson.oss.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Multipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericsson.oss.entites.CommandeClient;
import com.ericsson.oss.entites.Df_kh;
import com.ericsson.oss.entites.Dfid;
import com.ericsson.oss.entites.Dmr_dmtool;
import com.ericsson.oss.entites.Dmtoolid;
import com.ericsson.oss.entites.Email_alarms;
import com.ericsson.oss.entites.Isql_usa;
import com.ericsson.oss.entites.Isql_usaid;
import com.ericsson.oss.entites.OssProblems;
import com.ericsson.oss.entites.Smtool_list;
import com.ericsson.oss.entites.Smtoolid;
import com.ericsson.oss.entites.Svcs;
import com.ericsson.oss.entites.Svcsid;
import com.ericsson.oss.services.IDf_khService;
import com.ericsson.oss.services.IDmr_dmtoolService;
import com.ericsson.oss.services.IEmail_alarmsService;
import com.ericsson.oss.services.IOssProblemsService;
import com.ericsson.oss.services.ISmtool_listService;
import com.ericsson.oss.services.ISvcsService;
import com.ericsson.oss.services.Iisql_usaService;

 
 


@Controller
@RequestMapping (value="/logimport")

public class OssLogParserController { 
	

	String path ;
	
	@Autowired 
	private IDmr_dmtoolService Dmr_dmtoolService ;
	@Autowired
    private Iisql_usaService Isql_usaService ;
      @Autowired 
private IDf_khService Df_khService ;
      @Autowired 
      private ISmtool_listService Smtool_listService ;
      @Autowired
      private ISvcsService SvcsService ;
      @Autowired
      private IOssProblemsService OssProblemsService ;
      @Autowired
      private IEmail_alarmsService email_alarmsService ;
	@RequestMapping (value="/")
public String logimport() {
		return "logimport/logimport";
		}
@RequestMapping(value="/parse",method=RequestMethod.POST)

public  String OssLogParser(HttpServletRequest request ) throws ParseException   {
	path =request.getParameter("chemin");
	File repertoire =new File(path);
	File [] fichier =repertoire.listFiles();
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class",
			"javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");

	Session session = Session.getDefaultInstance(props,
		new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ossalarme@gmail.com","oss123456");
			}
		});
	             int i;
	             BufferedReader br = null;
	             for(i=0;i<fichier.length;i++) {
		
		
	
				    try {

					    String line;
						br = new BufferedReader(new FileReader(fichier[i]));
					    int indicedeprob=0;
					    Date date = new Date() ;
						Date TIME = new Date() ;
						String datestr = null;
						String timestr = null;
						while ((line = br.readLine()) != null) {
							   if (line.indexOf("start command date")!= -1) {
		                          String dL =br.readLine().toString();
		       					  DateFormat df = new SimpleDateFormat("MM-dd-yyyy",Locale.ENGLISH);
		       					  date=df.parse(dL);
		                		  datestr=df.format(date);
		                		  datestr=datestr.replace("-", "");
		                	   }
		                	   if (line.indexOf("start command time")!= -1) {
		                           String dL =br.readLine().toString();
		                           DateFormat df = new SimpleDateFormat("HH-mm",Locale.ENGLISH);
		          				   TIME=df.parse(dL);
		          				   timestr=df.format(TIME);
		          				   timestr=timestr.replace("-", "");
		                   	   }
							   if (line.indexOf("start command /ericsson/dmr/bin/dmtool")!= -1) {
								  line = br.readLine();
							   if (line.indexOf("end command /ericsson/dmr/bin/dmtool")== -1) {
			                       while (line.indexOf("Diskgroup/Volume")== -1) {
				                      line = br.readLine();}
			                          line =br.readLine();
			                          line =br.readLine();
							          String ligne = br.readLine();
							          if (ligne!= null) {
			                          while (ligne.indexOf("Defined")== -1) {
		                                 String lo=ligne.trim();
							             Scanner sc =new Scanner(lo);
						                 String a="a";
			                             String b="b";
						                 String c="c";
						                 Dmr_dmtool dmrtool = new Dmr_dmtool() ;
						                 while (sc.hasNextLine()) {
							               a=sc.next().toString();
										   if (sc.hasNext()) {
										   b=sc.next().toString();}
										   if (sc.hasNext()) {
										   c=sc.next().toString();}
						                     dmrtool.setMirror_1(b);
											 dmrtool.setMirror_2(c);
											 Dmtoolid dmtoolid =new Dmtoolid(a,date,TIME);
											 dmrtool.setDmtoolid(dmtoolid);
										     Dmr_dmtoolService.update(dmrtool);
												 if (b!= c) {
													 try {
														 OssProblems ossproblems= new OssProblems();
														String paramvalue_1="Dmtool:mirooring problem";
														String paramvalue_2="Dmtool";
									                        String str ;
															Long lon;
															int k=0;
															int l=0;
															String mail ="mail";
															String sendto="";
															str =datestr +timestr+indicedeprob;
															lon=Long.parseLong(str);
															ossproblems.setProblemid(lon);
															ossproblems.setProblem("Dmtool:mirooring problem");
															
															ossproblems.setProblem_source(fichier[i].getPath());
															
															OssProblemsService.update(ossproblems);
															String messagetext="Dear user," +"\n"+"problem name :Dmtool:mirooring problem"+"\n problem id:"+ossproblems.getProblemid()+
																	"\n\n the mirror A diffrent than B for diskgroup"+ a +", please try to make things right!"+"\n\n"+"those are some solutions : ";
															List<OssProblems> ossproblemssolution =OssProblemsService.findS(paramvalue_1);
															if (ossproblemssolution.isEmpty()) {
																ossproblemssolution = new ArrayList<OssProblems>();
															} else {
															for(OssProblems hadsolution :ossproblemssolution) {
																 String [] solution = new String[4];
																
																solution[k]=hadsolution.getProposed_solution();
																messagetext=messagetext+"\n\n"+solution[k];
																k++;
															}}
															List<Email_alarms> listeofmails =email_alarmsService.findObject(paramvalue_2);
															if (listeofmails.isEmpty()) {
																listeofmails = new ArrayList<Email_alarms>();
															} else {
															for(Email_alarms mails :listeofmails) {
																 String [] list = new String[30];
																
																list [l]=mails.getIdemail_alarms().getMail();
																mail=list[l];
																
																sendto=sendto+","+list[l];
																l++;
															
															Message message = new MimeMessage(session);
															message.setFrom(new InternetAddress("ossalarme@gmail.com"));
															message.setRecipients(Message.RecipientType.TO,
															InternetAddress.parse(mail));
															message.setSubject("ossprobleme");
															BodyPart messageBodyPart = new MimeBodyPart();
															messageBodyPart.setText(messagetext);
															Multipart multipart = new MimeMultipart();
														    multipart.addBodyPart(messageBodyPart);
															messageBodyPart = new MimeBodyPart();
													        DataSource source = new FileDataSource(fichier[i].getPath());
													        messageBodyPart.setDataHandler(new DataHandler(source));
													        messageBodyPart.setFileName(fichier[i].getPath());
													        multipart.addBodyPart(messageBodyPart);
													        message.setContent(multipart);
													        Transport.send(message);
													        
															}}
															ossproblems.setMail_send_to(sendto);
													         indicedeprob ++;
														} catch (MessagingException m) {
															throw new RuntimeException(m);
														}
													 
												 }
												
											 
											
												
											 
											 
											  			
							
						   }
						   ligne = br.readLine();
						   }
					}
							}}
							if (line.indexOf("start command smtool list")!= -1) {
								
								
								String ligne = br.readLine();
												if (ligne!= null) {
											
												while (ligne.indexOf("end command smtool list")== -1) {
													
												String lo=ligne.trim();
												Scanner sc =new Scanner(lo);
											   String a="a";
								               String b="b";
											   
											   Smtool_list smtool_list = new Smtool_list() ;
											   while (sc.hasNextLine()) {
												               
															
															  a=sc.next().toString();
															  if (sc.hasNext()) {
															  b=sc.next().toString();}
															 
															  smtool_list.setState(b);
															  Smtoolid smtoolid =new Smtoolid(a,date,TIME);
															  smtool_list.setSmtoolid(smtoolid);
																 Smtool_listService.update(smtool_list);
																 if (b.indexOf("offline")!= -1) {
																	 try {
																		 OssProblems ossproblems= new OssProblems();
																		String paramvalue="smtool_problem:offline";
																		String paramvalue_2="smtool";
																		
													                        String str ;
																			Long lon;
																			int k=0;
																			int l=0;
																			String mail ="mail";
																			String sendto="";
																			str =datestr +timestr+indicedeprob;
																			lon=Long.parseLong(str);
																			ossproblems.setProblemid(lon);
																			ossproblems.setProblem("smtool_problem:offline");
																		    ossproblems.setProblem_source(fichier[i].getPath());
																			
																			OssProblemsService.update(ossproblems);
																			String messagetext="Dear user," +"\n"+"problem name :smtool_problem:offline"+"\n problem id:"+ossproblems.getProblemid()+
																					"\n\n the state of application "+ a + " is :"+ b+", please try to make things right!"+"\n\n"+"those are some solutions : ";
																			List<OssProblems> ossproblemssolution =OssProblemsService.findS(paramvalue);
																			if (ossproblemssolution.isEmpty()) {
																				ossproblemssolution = new ArrayList<OssProblems>();
																			} else {
																			for(OssProblems hadsolution :ossproblemssolution) {
																				 String [] solution = new String[4];
																				
																				solution[k]=hadsolution.getProposed_solution();
																				messagetext=messagetext+"\n\n"+solution[k];
																				k++;
																			}}
																			List<Email_alarms> listeofmails =email_alarmsService.findObject(paramvalue_2);
																			if (listeofmails.isEmpty()) {
																				listeofmails = new ArrayList<Email_alarms>();
																			} else {
																			for(Email_alarms mails :listeofmails) {
																				 String [] list = new String[30];
																				
																				list [l]=mails.getIdemail_alarms().getMail();
																				mail=list[l];
																				System.out.println(mail);
																				sendto=sendto+","+list[l];
																				l++;
																			
																			Message message = new MimeMessage(session);
																			message.setFrom(new InternetAddress("ossalarme@gmail.com"));
																			message.setRecipients(Message.RecipientType.TO,
																			InternetAddress.parse(mail));
																			message.setSubject("ossprobleme");
																			BodyPart messageBodyPart = new MimeBodyPart();
																			messageBodyPart.setText(messagetext);
																			Multipart multipart = new MimeMultipart();
																		    multipart.addBodyPart(messageBodyPart);
																			messageBodyPart = new MimeBodyPart();
																	        DataSource source = new FileDataSource(fichier[i].getPath());
																	        messageBodyPart.setDataHandler(new DataHandler(source));
																	        messageBodyPart.setFileName(fichier[i].getPath());
																	        multipart.addBodyPart(messageBodyPart);
																	        message.setContent(multipart);
																	        Transport.send(message);
																	        
																			}}
																			ossproblems.setMail_send_to(sendto);
																	         indicedeprob ++;
																		} catch (MessagingException e) {
																			throw new RuntimeException(e);
																		}
																	 
																 }
																	
																 
																 
																  			
												
											   }
											   ligne = br.readLine();
											   }
										}
												}
							if (line.indexOf("start command isql -Usa")!= -1) {
								  line = br.readLine();
								  
							   if (line.indexOf("end command isql -Usa")== -1) {


			                       while (line.indexOf("select count(*) from FMA_alarm_list")== -1) {
				                      line = br.readLine();}
			                         line =br.readLine();
			                         line =br.readLine();
			                         line =br.readLine();
			                         
							          String ligne = br.readLine();
							          int f=0;
							          int b=0;
							          int d=0;
							          Scanner sc;
							          String lo;
							          Isql_usa isql = new Isql_usa() ;
							          if (ligne!= null) {
		                                lo=ligne.trim();
		                               sc =new Scanner(lo);
						                 
						                 while (sc.hasNextLine()) {
						                	 String a="a";
						                	
						                	 a=sc.next().toString();
						                	 b=Integer.parseInt(a);
						                     isql.setFma_alarm_list(b);
						                     System.out.println(isql.getFma_alarm_list());
						                     }}
						                     while (line.indexOf("select count(*) from FMA_alarm_log")== -1) {
							                      line = br.readLine();} 
						                     line =br.readLine();
					                         line =br.readLine();
					                         line =br.readLine();
									          ligne = br.readLine();
									          if (ligne!= null) {
				                                lo=ligne.trim();
				                                 sc =new Scanner(lo);
								                 while (sc.hasNextLine()) {
								                	 String c="c";
								                	 
								                	 c=sc.next().toString();
								                	 d=Integer.parseInt(c);
								                     isql.setFma_alarm_log(d);
								                     System.out.println(isql.getFma_alarm_log());}}
									          while (line.indexOf("select count(*) from FMA_operator_log")== -1) {
									                      line = br.readLine();} 
								                     line =br.readLine();
							                         line =br.readLine();
							                         line =br.readLine();
											          ligne = br.readLine();
											          if (ligne!= null) {
						                                lo=ligne.trim();
						                                 sc =new Scanner(lo);
										                 while (sc.hasNextLine()) {
										                	 String e="e";
										                	 
										                	 e=sc.next().toString();
										                	 
										                	 f=Integer.parseInt(e);
										                	 System.out.println("cest moi f");
										                	 
										                     isql.setFma_operator_log(f);
										                     Isql_usaid isqlid =new Isql_usaid(date,TIME);
											                 isql.setIsql_usaid(isqlid);
											                 System.out.println(isql.getFma_operator_log());
											                 Isql_usaService.update(isql);
											 
										                 }}
												
												 if (b>30000000) {
													 try {
														 OssProblems ossproblems= new OssProblems();
														String paramvalue_1="isql_usa:database";
														String paramvalue_2="isql_usa";
									                        String str ;
															Long lon;
															int k=0;
															int l=0;
															String mail ="mail";
															String sendto="";
															str =datestr +timestr+indicedeprob;
															lon=Long.parseLong(str);
															ossproblems.setProblemid(lon);
															ossproblems.setProblem("isql_usa:database");
															
															ossproblems.setProblem_source(fichier[i].getPath());
															
															OssProblemsService.update(ossproblems);
															String messagetext="Dear user," +"\n"+"problem name :isql_usa:database"+"\n problem id:"+ossproblems.getProblemid()+
																	"\n\n the table FMA_alarm_log shoudl be cleaned it contains"+ b +", please try to make things right!"+"\n\n"+"those are some solutions : ";
															List<OssProblems> ossproblemssolution =OssProblemsService.findS(paramvalue_1);
															if (ossproblemssolution.isEmpty()) {
																ossproblemssolution = new ArrayList<OssProblems>();
															} else {
															for(OssProblems hadsolution :ossproblemssolution) {
																 String [] solution = new String[4];
																
																solution[k]=hadsolution.getProposed_solution();
																messagetext=messagetext+"\n\n"+solution[k];
																k++;
															}}
															List<Email_alarms> listeofmails =email_alarmsService.findObject(paramvalue_2);
															if (listeofmails.isEmpty()) {
																listeofmails = new ArrayList<Email_alarms>();
															} else {
															for(Email_alarms mails :listeofmails) {
																 String [] list = new String[30];
																
																list [l]=mails.getIdemail_alarms().getMail();
																mail=list[l];
																sendto=sendto+","+list[l];
																l++;
															
															Message message = new MimeMessage(session);
															message.setFrom(new InternetAddress("ossalarme@gmail.com"));
															message.setRecipients(Message.RecipientType.TO,
															InternetAddress.parse(mail));
															message.setSubject("ossprobleme");
															BodyPart messageBodyPart = new MimeBodyPart();
															messageBodyPart.setText(messagetext);
															Multipart multipart = new MimeMultipart();
														    multipart.addBodyPart(messageBodyPart);
															messageBodyPart = new MimeBodyPart();
													        DataSource source = new FileDataSource(fichier[i].getPath());
													        messageBodyPart.setDataHandler(new DataHandler(source));
													        messageBodyPart.setFileName(fichier[i].getPath());
													        multipart.addBodyPart(messageBodyPart);
													        message.setContent(multipart);
													        Transport.send(message);
													        
															}}
															ossproblems.setMail_send_to(sendto);
													         indicedeprob ++;
														} catch (MessagingException m) {
															throw new RuntimeException(m);
														}
													 
												 }
												 if (d>500000000) {
													 try {
														 OssProblems ossproblems= new OssProblems();
														String paramvalue_1="isql_usa:database";
														String paramvalue_2="isql_usa";
									                        String str ;
															Long lon;
															int k=0;
															int l=0;
															String mail ="mail";
															String sendto="";
															str =datestr +timestr+indicedeprob;
															lon=Long.parseLong(str);
															ossproblems.setProblemid(lon);
															ossproblems.setProblem("isql_usa:database");
															
															ossproblems.setProblem_source(fichier[i].getPath());
															
															OssProblemsService.update(ossproblems);
															String messagetext="Dear user," +"\n"+"problem name :isql_usa:database"+"\n problem id:"+ossproblems.getProblemid()+
																	"\n\n the table FMA_alarm_log shoudl be cleaned it contains"+ d+", please try to make things right!"+"\n\n"+"those are some solutions : ";
															List<OssProblems> ossproblemssolution =OssProblemsService.findS(paramvalue_1);
															if (ossproblemssolution.isEmpty()) {
																ossproblemssolution = new ArrayList<OssProblems>();
															} else {
															for(OssProblems hadsolution :ossproblemssolution) {
																 String [] solution = new String[4];
																
																solution[k]=hadsolution.getProposed_solution();
																messagetext=messagetext+"\n\n"+solution[k];
																k++;
															}}
															List<Email_alarms> listeofmails =email_alarmsService.findObject(paramvalue_2);
															if (listeofmails.isEmpty()) {
																listeofmails = new ArrayList<Email_alarms>();
															} else {
															for(Email_alarms mails :listeofmails) {
																 String [] list = new String[30];
																
																list [l]=mails.getIdemail_alarms().getMail();
																mail=list[l];
																sendto=sendto+","+list[l];
																l++;
															
															Message message = new MimeMessage(session);
															message.setFrom(new InternetAddress("ossalarme@gmail.com"));
															message.setRecipients(Message.RecipientType.TO,
															InternetAddress.parse(mail));
															message.setSubject("ossprobleme");
															BodyPart messageBodyPart = new MimeBodyPart();
															messageBodyPart.setText(messagetext);
															Multipart multipart = new MimeMultipart();
														    multipart.addBodyPart(messageBodyPart);
															messageBodyPart = new MimeBodyPart();
													        DataSource source = new FileDataSource(fichier[i].getPath());
													        messageBodyPart.setDataHandler(new DataHandler(source));
													        messageBodyPart.setFileName(fichier[i].getPath());
													        multipart.addBodyPart(messageBodyPart);
													        message.setContent(multipart);
													        Transport.send(message);
													        
															}}
															ossproblems.setMail_send_to(sendto);
													         indicedeprob ++;
														} catch (MessagingException m) {
															throw new RuntimeException(m);
														}
													 
												 }
												 if (f>30000000) {
													 try {
														 OssProblems ossproblems= new OssProblems();
														String paramvalue_1="isql_usa:database";
														String paramvalue_2="isql_usa";
									                        String str ;
															Long lon;
															int k=0;
															int l=0;
															String mail ="mail";
															String sendto="";
															str =datestr +timestr+indicedeprob;
															lon=Long.parseLong(str);
															ossproblems.setProblemid(lon);
															ossproblems.setProblem("isql_usa:database");
															
															ossproblems.setProblem_source(fichier[i].getPath());
															
															OssProblemsService.update(ossproblems);
															String messagetext="Dear user," +"\n"+"problem name :isql_usa:database"+"\n problem id:"+ossproblems.getProblemid()+
																	"\n\n the table FMA_operator_log shoudl be cleaned it contains"+ f+", please try to make things right!"+"\n\n"+"those are some solutions : ";
															List<OssProblems> ossproblemssolution =OssProblemsService.findS(paramvalue_1);
															if (ossproblemssolution.isEmpty()) {
																ossproblemssolution = new ArrayList<OssProblems>();
															} else {
															for(OssProblems hadsolution :ossproblemssolution) {
																 String [] solution = new String[4];
																
																solution[k]=hadsolution.getProposed_solution();
																messagetext=messagetext+"\n\n"+solution[k];
																k++;
															}}
															List<Email_alarms> listeofmails =email_alarmsService.findObject(paramvalue_2);
															if (listeofmails.isEmpty()) {
																listeofmails = new ArrayList<Email_alarms>();
															} else {
															for(Email_alarms mails :listeofmails) {
																 String [] list = new String[30];
																
																list [l]=mails.getIdemail_alarms().getMail();
																mail=list[l];
																sendto=sendto+","+list[l];
																l++;
															
															Message message = new MimeMessage(session);
															message.setFrom(new InternetAddress("ossalarme@gmail.com"));
															message.setRecipients(Message.RecipientType.TO,
															InternetAddress.parse(mail));
															message.setSubject("ossprobleme");
															BodyPart messageBodyPart = new MimeBodyPart();
															messageBodyPart.setText(messagetext);
															Multipart multipart = new MimeMultipart();
														    multipart.addBodyPart(messageBodyPart);
															messageBodyPart = new MimeBodyPart();
													        DataSource source = new FileDataSource(fichier[i].getPath());
													        messageBodyPart.setDataHandler(new DataHandler(source));
													        messageBodyPart.setFileName(fichier[i].getPath());
													        multipart.addBodyPart(messageBodyPart);
													        message.setContent(multipart);
													        Transport.send(message);
													        
															}}
															ossproblems.setMail_send_to(sendto);
													         indicedeprob ++;
														} catch (MessagingException m) {
															throw new RuntimeException(m);
														}
													 
												 }
												
											 
											
												
											 
											 
											  			
							
											          }
						   
						   
					}
							
						   }
						   line = br.readLine();
				 }
							
					
						   catch (IOException e) {
								e.printStackTrace();
							} finally {
								try {
									if (br != null)
										br.close();

								} catch (IOException ex) {
									ex.printStackTrace();
								}
							}
	}
					return "redirect:/logimport/";
				}

}



