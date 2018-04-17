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
import com.ericsson.oss.entites.OssProblems;
import com.ericsson.oss.entites.Smtool_list;
import com.ericsson.oss.entites.Smtoolid;
import com.ericsson.oss.entites.Svcs;
import com.ericsson.oss.entites.Svcsid;
import com.ericsson.oss.services.IDf_khService;
import com.ericsson.oss.services.IDmr_dmtoolService;
import com.ericsson.oss.services.IOssProblemsService;
import com.ericsson.oss.services.ISmtool_listService;
import com.ericsson.oss.services.ISvcsService;

 
 

@Controller
@RequestMapping (value="/logimport")

public class OssLogParserController { 
	

	String path ;
	
	@Autowired 
	private IDmr_dmtoolService Dmr_dmtoolService ;
      @Autowired 
private IDf_khService Df_khService ;
      @Autowired 
      private ISmtool_listService Smtool_listService ;
      @Autowired
      private ISvcsService SvcsService ;
      @Autowired
      private IOssProblemsService OssProblemsService ;
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
														String paramvalue="Dmtool:mirooring problem";
									                        String str ;
															Long lon;
															int k=0;
															str =datestr +timestr+indicedeprob;
															lon=Long.parseLong(str);
															ossproblems.setProblemid(lon);
															ossproblems.setProblem("Dmtool:mirooring problem");
															ossproblems.setMail_send_to("jihar.sahraoui@gmail.com");
															ossproblems.setProblem_source(fichier[i].getPath());
															
															OssProblemsService.update(ossproblems);
															String messagetext="Dear user," +"\n"+"problem name :Dmtool:mirooring problem"+"\n problem id:"+ossproblems.getProblemid()+
																	"\n\n the mirror A diffrent than B for disgroup"+ a +", please try to make things right!"+"\n\n"+"those are some solutions : ";
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
															Message message = new MimeMessage(session);
															message.setFrom(new InternetAddress("ossalarme@gmail.com"));
															message.setRecipients(Message.RecipientType.TO,
															InternetAddress.parse("jihar.sahraoui@gmail.com"));
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
							if (line.indexOf("start command df -kh")!= -1) {
								
								br.readLine();
								String ligne = br.readLine();
								if (ligne!= null) {
							
								while (ligne.indexOf("end command df -kh")== -1) {
									
								String lo=ligne.trim();
								Scanner sc =new Scanner(lo);
							   String a="";
				               String g ="";
							   String h="";
							   String ii ="";
							   String j="";
							   String f="";
							   float b=0;
							   float c=0;
							   float d=0;
							   float e=0;
							   Df_kh Df_kh = new Df_kh() ;
							   
							   while (sc.hasNextLine()) {
								               
											
											  a=sc.next().toString();
											  if (sc.hasNext()) {
											  g=sc.next().toString();
											  if (g.endsWith("K")) {
												  g= g.replace("K", "");
											      b = Float.parseFloat(g);
											  };
											  if(g.endsWith("G")) {
												  g= g.replace("G", "");
												  b = Float.parseFloat(g);
												  b=b*1000000;
											  };
											  if(g.endsWith("M")) {
												  g= g.replace("M", "");
												  b = Float.parseFloat(g);
												  b=b*1000;
											  };}
											  
											  if (sc.hasNext()) {
												  h=sc.next().toString();
												  if (h.endsWith("K")) {
													  h= h.replace("K", "");
												      c = Float.parseFloat(h);
												  };
												  if(h.endsWith("G")) {
													  h= h.replace("G", "");
													  c = Float.parseFloat(h);
													  c=c*1000000;
												  };
												  if(h.endsWith("M")) {
													  h= h.replace("M", "");
													  c = Float.parseFloat(h);
													  c=c*1000;
												  };
												  }
											  if (sc.hasNext()) {
												  
												   ii=sc.next().toString();
													  if (ii.endsWith("K")) {
														  ii= ii.replace("K", "");
													      d = Float.parseFloat(ii);
													  };
													  if(ii.endsWith("G")) {
														  ii= ii.replace("G", "");
														  d = Float.parseFloat(ii);
														  d=d*1000000;
													  };
													  if(ii.endsWith("M")) {
														  ii= ii.replace("M", "");
														  d = Float.parseFloat(ii);
														  d=d*1000;
													  };
												  }
											  if (sc.hasNext()) {
												  j=sc.next().toString();
												  j= j.replace("%", "");
												  e = Float.parseFloat(j);
												  }
											  if (sc.hasNext()) {
												  f=sc.next().toString();
											  }
							                if (g=="" && h=="" && ii==""&&j==""&&f=="") {
							                   Df_kh.setFilesysteme(a);
							                	ligne = br.readLine();
							                		lo=ligne.trim();
							                	
							    				sc =new Scanner(lo);
							    				   
							    				   while (sc.hasNextLine()) {
							    					               
							    								
							    								  
							    								  if (sc.hasNext()) {
							    								  g=sc.next().toString();
							    								  if (g.endsWith("K")) {
							    									  g= g.replace("K", "");
							    								      b = Float.parseFloat(g);
							    								  };
							    								  if(g.endsWith("G")) {
							    									  g= g.replace("G", "");
							    									  b = Float.parseFloat(g);
							    									  b=b*1000000;
							    								  };
							    								  if(g.endsWith("M")) {
							    									  g= g.replace("M", "");
							    									  b = Float.parseFloat(g);
							    									  b=b*1000;
							    								  };}
							    								  
							    								  if (sc.hasNext()) {
							    									  h=sc.next().toString();
							    									  if (h.endsWith("K")) {
							    										  h= h.replace("K", "");
							    									      c = Float.parseFloat(h);
							    									  };
							    									  if(h.endsWith("G")) {
							    										  h= h.replace("G", "");
							    										  c = Float.parseFloat(h);
							    										  c=c*1000000;
							    									  };
							    									  if(h.endsWith("M")) {
							    										  h= h.replace("M", "");
							    										  c = Float.parseFloat(h);
							    										  c=c*1000;
							    									  };
							    									  }
							    								  if (sc.hasNext()) {
							    									  
							    									   ii=sc.next().toString();
							    										  if (ii.endsWith("K")) {
							    											  ii= ii.replace("K", "");
							    										      d = Float.parseFloat(ii);
							    										  };
							    										  if(ii.endsWith("G")) {
							    											  ii= ii.replace("G", "");
							    											  d = Float.parseFloat(ii);
							    											  d=d*1000000;
							    										  };
							    										  if(ii.endsWith("M")) {
							    											  ii= ii.replace("M", "");
							    											  d = Float.parseFloat(ii);
							    											  d=d*1000;
							    										  };
							    									  }
							    								  if (sc.hasNext()) {
							    									  j=sc.next().toString();
							    									  j= j.replace("%", "");
							    									  e = Float.parseFloat(j);
							    									  }
							    								  if (sc.hasNext()) {
							    									  f=sc.next().toString();
							    								  }
							                		
							                	}
												  Df_kh.setMemory_size(b);
												  Df_kh.setMemory_used(c);
												  Df_kh.setMemory_avail(d);
												  Df_kh.setCapacity(e);
												  Dfid dfid =new Dfid(f,date,TIME);
												  Df_kh.setDfid(dfid);
												  Df_khService.update(Df_kh);
							                }
											  
											  
											  Df_kh.setFilesysteme(a);
											  Df_kh.setMemory_size(b);
											  Df_kh.setMemory_used(c);
											  Df_kh.setMemory_avail(d);
											  Df_kh.setCapacity(e);
											  Dfid dfid =new Dfid(f,date,TIME);
											  Df_kh.setDfid(dfid);
											  Df_khService.update(Df_kh);
											  
													
											  
												 
												  			
							   }
							   ligne = br.readLine();
							   }
							   
							   }
						}
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
																		 
																		 
																		    String str ;
																			Long lon;
																			
																			int k=0;
																			str =datestr +timestr+indicedeprob;
																			lon=Long.parseLong(str);
																			ossproblems.setProblemid(lon);
																			ossproblems.setProblem("smtool_problem:offline");
																			ossproblems.setMail_send_to("jihar.sahraoui@gmail.com");
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
																			Message message = new MimeMessage(session);
																			message.setFrom(new InternetAddress("ossalarme@gmail.com"));
																			message.setRecipients(Message.RecipientType.TO,
																					InternetAddress.parse("jihar.sahraoui@gmail.com"));
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
							if (line.indexOf("start command svcs")!= -1) {
								
								
				

									br.readLine();
								String ligne = br.readLine();
								if (ligne!= null) {
							
								while (ligne.indexOf("end command svcs")== -1) {
									
								String lo=ligne.trim();
								Scanner sc =new Scanner(lo);
							   String a="a";
				               String b="b";
							   String c="c";
							   Svcs svcs = new Svcs() ;
							   while (sc.hasNextLine()) {
								   Date da = new Date() ;
											
											  a=sc.next().toString();
											  if (sc.hasNext()) {
											  b=sc.next().toString();
											  if (b.indexOf(":")== -1) {
											  
												DateFormat de = new SimpleDateFormat("MMM_dd",Locale.ENGLISH);
												da=de.parse(b);}
											  else{
												DateFormat de = new SimpleDateFormat("HH:mm:ss",Locale.ENGLISH);
												da=de.parse(b);}
											  }
											  if (sc.hasNext()) {
											  c=sc.next().toString();}
							                
											  
											  
											  svcs.setState(a);
												
												svcs.setStime(da);
												 
												Svcsid svcsid =new Svcsid(c,date,TIME);
												  svcs.setSvcsid(svcsid);
												SvcsService.update(svcs);
												 
												 
												 
												  			
								
							   }
							   ligne = br.readLine();
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



