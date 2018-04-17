package com.ericsson.oss;

import java.io.BufferedReader;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;

import com.ericsson.oss.entites.Df_kh;
import com.ericsson.oss.entites.Dfid;
import com.ericsson.oss.entites.Dmr_dmtool;
import com.ericsson.oss.entites.Dmtoolid;
import com.ericsson.oss.entites.Smtool_list;
import com.ericsson.oss.entites.Smtoolid;
import com.ericsson.oss.entites.Svcs;
import com.ericsson.oss.entites.Svcsid;
import com.ericsson.oss.services.IDf_khService;
import com.ericsson.oss.services.IDmr_dmtoolService;
import com.ericsson.oss.services.ISmtool_listService;

public class fact {
	@Autowired 
	private IDmr_dmtoolService Dmr_dmtoolService ;
	@Autowired
	private IDf_khService Df_khService ;
	@Autowired 
	private ISmtool_listService Smtool_listService ;
	
	public static void main(String[] args)  throws ParseException {
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
		
		File repertoire =new File("C:\\Users\\user\\Downloads\\ab");
		File[] fichier =repertoire.listFiles();
		int i;
		  BufferedReader br = null;
		  for(i=0;i<fichier.length;i++) {
			  System.out.println(fichier[i]);
			  
		 try {
              String line;
				
				br = new BufferedReader(new FileReader(fichier[i]));
				 
				 
					Date date = new Date() ;
					Date TIME = new Date() ;
                   while ((line = br.readLine()) != null) {
                	   if (line.indexOf("start command date")!= -1) {
                		   
                		   String dL =br.readLine().toString();
                		   System.out.println(dL);
       					DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
       					date=df.parse(dL);
       					System.out.println(date);
                		   
                	   }
                	   if (line.indexOf("start command time")!= -1) {
                		   
                   		String dL =br.readLine().toString();
             				
          					DateFormat df = new SimpleDateFormat("hh-mm");
          					TIME=df.parse(dL);
          					System.out.println(TIME);
                   		   
                   	   }
                	   
					if (line.indexOf("start command /ericsson/dmr/bin/dmtool")!= -1) {
						
						System.out.println(line);
						line=br.readLine();
						if (line.indexOf("end command /ericsson/dmr/bin/dmtool")== -1) {
							System.out.println(line.indexOf("Diskgroup/Volume"));
	while(line.indexOf("Diskgroup/Volume")== -1) 
	{
		line = br.readLine();}
	
	line =br.readLine();
	line =br.readLine();
						System.out.println(line);
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
				                
								  
								  
								  Dmtoolid dmtoolid =new Dmtoolid(a,date,TIME);
								  dmrtool.setDmtoolid(dmtoolid);
									 dmrtool.setMirror_1(b);
									 dmrtool.setMirror_2(c);
									 
									
									 System.out.println(dmrtool.getMirror_1());
									 System.out.println(dmrtool.getMirror_2());
									 System.out.println(date);
										
									 
									 
									  			
					
				   }
				   ligne = br.readLine();
				   }
			}}
					}
					
				
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
										  ii= ii.replace("G", ii);
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
			    											  ii= ii.replace("G", ii);
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
			                }
							  
							  
							  Df_kh.setFilesysteme(a);
							  Df_kh.setMemory_size(b);
							  Df_kh.setMemory_used(c);
							  Df_kh.setMemory_avail(d);
							  Df_kh.setCapacity(e);
							  Dfid dfid =new Dfid(f,date,TIME);
							  Df_kh.setDfid(dfid);
								
								 
								 
								  			
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
							  
			                
							  
							  
							  smtool_list.setState(b);;
							  Smtoolid smtoolid =new Smtoolid(a,date,TIME);
							  smtool_list.setSmtoolid(smtoolid);
							  
								 System.out.println(smtool_list.getState());
								 System.out.println(smtool_list.getSmtoolid());
							 if (b.indexOf("offline")!= -1) {
								 try {

										Message message = new MimeMessage(session);
										message.setFrom(new InternetAddress("ossalarme@gmail.com"));
										message.setRecipients(Message.RecipientType.TO,
												InternetAddress.parse("jihar.sahraoui@gmail.com"));
										message.setSubject("ossprobleme");
										message.setText("Dear user," +
												"\n\n the state of application "+ a + "is :"+ b+", please try to make things right!"+"\\n\\n"+fichier[i]);

										Transport.send(message);

										System.out.println("Done");

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
				
				line = br.readLine();
while(line.indexOf("STATE")== -1) {
	line = br.readLine();}

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
								DateFormat de = new SimpleDateFormat("hh:mm:ss",Locale.ENGLISH);
								da=de.parse(b);}
							  }
							  if (sc.hasNext()) {
							  c=sc.next().toString();}
			                
							  
							  
							  svcs.setState(a);
								
							  Svcsid svcsid =new Svcsid(c,date,TIME);
							  svcs.setSvcsid(svcsid);
							
								
								 ;
								 
								 
								 
								  			
				
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
	
	}
}
