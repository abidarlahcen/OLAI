package com.ericsson.oss;

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
import java.util.StringTokenizer;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ericsson.oss.Convert;
import com.ericsson.oss.MailingProblems;
import com.ericsson.oss.entites.CommandeClient;
import com.ericsson.oss.entites.Df_kh;
import com.ericsson.oss.entites.Df_kh_Seuil;
import com.ericsson.oss.entites.Dfid;
import com.ericsson.oss.entites.Dmr_dmtool;
import com.ericsson.oss.entites.Dmtoolid;
import com.ericsson.oss.entites.LogName;
import com.ericsson.oss.entites.OSSPrtdiagMDS;
import com.ericsson.oss.entites.OSSPrtdiagPS;
import com.ericsson.oss.entites.OSSPrtdiagUS;
import com.ericsson.oss.entites.OSS_df;
import com.ericsson.oss.entites.OSS_vxdisk;
import com.ericsson.oss.entites.OssProblems;
import com.ericsson.oss.entites.Smtool_list;
import com.ericsson.oss.entites.Smtoolid;
import com.ericsson.oss.entites.Svcs;
import com.ericsson.oss.entites.Svcsid;
import com.ericsson.oss.services.IDf_khService;
import com.ericsson.oss.services.IDf_kh_SeuilService;
import com.ericsson.oss.services.IDmr_dmtoolService;
import com.ericsson.oss.services.IOSS_dfService;
import com.ericsson.oss.services.IOSS_vxdiskService;
import com.ericsson.oss.services.IOssProblemsService;
import com.ericsson.oss.services.ISmtool_listService;
import com.ericsson.oss.services.ISvcsService;


public class Test { 
	
	
    public static void main(String[] args) throws ParseException {
    	
    	Test test = new Test();
    	test.Test();
    }

	String path;
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

    
    //----------------------Instanciation Services----------------------------//
    @Autowired
    private IDf_kh_SeuilService DfSeuilService ;
    @Autowired
	private IOSS_dfService dfService ;
	@Autowired
	private IOSS_vxdiskService vxdiskService;
	@Autowired
	private IOSS_vxdiskService PrtdiagPSService;
	@Autowired
	private IOSS_vxdiskService PrtdiagMDSService;
	@Autowired
	private IOSS_vxdiskService PrtdiagUSService;
	//-----------------------------------------------------------------------//
    

	public void Test() throws ParseException {
		
		//-------------Instanciation entités---------------------
		
		OSS_df dfkh= new OSS_df();
		OSS_vxdisk vxdisk= new OSS_vxdisk();
		OSSPrtdiagPS PrtdiagPS=new OSSPrtdiagPS();
		OSSPrtdiagMDS PrtdiagMDS=new OSSPrtdiagMDS();
		OSSPrtdiagUS PrtdiagUS=new OSSPrtdiagUS();
		
		//-------------------------------------------------------
		

		File repertoire =new File("D:\\Studies\\PFE\\Logs2");
		File [] fichier =repertoire.listFiles();
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");

	    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("OSS.Problems@gmail.com","OSSProblems");
				}});
	    int i;
	    BufferedReader br = null;
	    
	    for(i=0;i<fichier.length;i++) {
	    	try {
			
	    		String line;
				br = new BufferedReader(new FileReader(fichier[i]));
				//-----------------------------------------------------------------
				
				//new ModelAndView("logimport","LogName",logname);
				//-----------------------------------------------------------------
				int indicedeprob=0;
				Date date = new Date() ;
				Date TIME = new Date() ;
				
				//-----Déclaration de time du Log de type "Time"--------------
				
				java.sql.Time tm= new java.sql.Time(date.getTime());
				
				//------------------------------------------------------------
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
		          		//---------- Time --------------------------
		          		tm = new java.sql.Time(TIME.getTime());
		          		//------------------------------------------
		          		timestr=df.format(TIME);
		          		timestr=timestr.replace("-", "");
		             }
		             
		             if (line.indexOf("start command /ericsson/dmr/bin/dmtool")!= -1) {
					
		            	 line = br.readLine();
		            	 if (line.indexOf("end command /ericsson/dmr/bin/dmtool")== -1) {

		            		 while (line.indexOf("Diskgroup/Volume")== -1) {
		            			 line = br.readLine();
		            		 }
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
													ossproblems.setMail_send_to("s.saoudi09@gmail.com");
													ossproblems.setProblem_source(fichier[i].getPath());
													OssProblemsService.update(ossproblems);
													String messagetext="Dear user," +"\n"+"problem name :Dmtool:mirooring problem"+"\n problem id:"+ossproblems.getProblemid()+
																	"\n\n the mirror A diffrent than B for disgroup"+ a +", please try to make things right!"+"\n\n"+"those are some solutions : ";
													List<OssProblems> ossproblemssolution =OssProblemsService.findS(paramvalue);
													if (ossproblemssolution.isEmpty()) {
														ossproblemssolution = new ArrayList<OssProblems>();
													}else{
														for(OssProblems hadsolution :ossproblemssolution) {
															String [] solution = new String[4];	
															solution[k]=hadsolution.getProposed_solution();
															messagetext=messagetext+"\n\n"+solution[k];
															k++;
															}}
															Message message = new MimeMessage(session);
															message.setFrom(new InternetAddress("OSS.Problems@gmail.com"));
															message.setRecipients(Message.RecipientType.TO,
															InternetAddress.parse("s.saoudi09@gmail.com"));
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
													        //Transport.send(message);
													         indicedeprob ++;
													}catch (MessagingException m) {
														throw new RuntimeException(m);
													}
													 
												 }											
						             	}
						             	ligne = br.readLine();
								 	}
							 }
					}}
		            //  -------------------- Commande df -kh : ---------------------------------
					if (line.indexOf("start command df -kh")!= -1) {
						br.readLine();
						line = br.readLine();
						while (line.indexOf("end command df -kh")== -1) {
							StringTokenizer st = new StringTokenizer(line);
			            	ArrayList<String> Att= new ArrayList<String>();
			            	while (st.hasMoreElements()) {
			            		Att.add(st.nextElement().toString());
			            	}
							Convert cnv= new Convert();
		        			dfkh.setFilesystem(Att.get(0));
		        			double Size= cnv.ConvertTo(Att.get(1));
				            dfkh.setSize(Size);
				            double Used= cnv.ConvertTo(Att.get(2));
				            dfkh.setUsed(Used);
				            double Avail= cnv.ConvertTo(Att.get(3));
				            dfkh.setAvail(Avail);
				            float Capacity= cnv.ConvertPercentage(Att.get(4));
				            dfkh.setCapacity(Capacity);
				            //--------------------------------------------------------------------------------
				            /*List<Df_kh_Seuil> DfSeuilList= DfSeuilService.selectAll();
				            if (Capacity > DfSeuilList.get(0).getDfSeuilMinorPb() ) {
				            	String Problem = "";
				            	if (Capacity > DfSeuilList.get(0).getDfSeuilMinorPb() && Capacity < DfSeuilList.get(0).getDfSeuilMajorPb()) {
				            		Problem="Command df -kh Capacity : Minor Problem";
				            	}
				            	if (Capacity >= DfSeuilList.get(0).getDfSeuilMajorPb() && Capacity <DfSeuilList.get(0).getDfSeuilCriticalPb()) {
				            		Problem="Command df -kh Capacity : Major Problem";
				            	}
				            	if (Capacity >= DfSeuilList.get(0).getDfSeuilCriticalPb()) {
				            		Problem="Command df -kh Capacity : Critical Problem";
				            	}
				            	Long ID;
			    				String IdString = datestr+timestr+indicedeprob;
			    				ID=Long.parseLong(IdString);
			    				OssProblems ossproblems= new OssProblems();
			    				ossproblems.setProblemid(ID);
			    				ossproblems.setProblem(Problem);
			    				ossproblems.setMail_send_to("s.saoudi09@gmail.com");
			    				ossproblems.setProblem_source(fichier[i].getPath());
			    				OssProblemsService.update(ossproblems);

				    			List<OssProblems> ossproblemssolutions =OssProblemsService.findS(Problem);
				    			
				    			MailingProblems MailProblem=new MailingProblems();
				    			MailProblem.SendMail(ID, Capacity, Att.get(0), fichier[i], ossproblemssolutions,Problem,"df -kh",session);
				    			indicedeprob++;
				    		}*/
				            //--------------------------------------------------------------------------------
				            dfkh.setMounted_on(Att.get(5));
				            dfkh.setDate(date);
				            dfkh.setTime(tm);
				            //dfService.save(dfkh); 
				            System.out.println(dfkh.getFilesystem());
				            System.out.println(dfkh.getSize());
				            System.out.println(dfkh.getUsed());
				            System.out.println(dfkh.getAvail());
				            System.out.println(dfkh.getCapacity());
				            System.out.println(dfkh.getMounted_on());
				            System.out.println(dfkh.getDate());
				            System.out.println(dfkh.getTime());
				            System.out.println("---------------");

							line = br.readLine();
						}	   
					}
					//--------------------- END Commande df -kh -----------------------------------
					
					//--------------------- Commande vxdisk ---------------------------------------
					if (line.indexOf("start command vxdisk list")!= -1) {
						String Disk = null;
						String Status = null;
						System.out.println("yes");
						
						line = br.readLine();
						while (line.indexOf("end command vxdisk list")== -1) {
							StringTokenizer st = new StringTokenizer(line);
			            	ArrayList<String> Att= new ArrayList<String>();
			            	while (st.hasMoreElements()) {
			            		Att.add(st.nextElement().toString());
			              	}
			            	if (Att.size()==6) {
			        			vxdisk.setDevice(Att.get(0).toString());
					            vxdisk.setType(Att.get(1).toString());
					            Disk=Att.get(0).toString();
					            vxdisk.setDisk(Att.get(2).toString());
					            vxdisk.setGroup(Att.get(3).toString());
					            Status=Att.get(4).toString();
					            vxdisk.setStatus(Att.get(4).toString()+" "+Att.get(5).toString());
					            vxdisk.setDate(date);
					            vxdisk.setTime(tm);
					            vxdiskService.save(vxdisk);
					        }
		            		if (Att.size()==5) {
			        			vxdisk.setDevice(Att.get(0).toString());
					            vxdisk.setType(Att.get(1).toString());
					            Disk=Att.get(0).toString();
					            vxdisk.setDisk(Att.get(2).toString());
					            vxdisk.setGroup(Att.get(3).toString());
					            Status=Att.get(4).toString();
					            vxdisk.setStatus(Att.get(4).toString());
					            vxdisk.setDate(date);
					            vxdisk.setTime(tm);
					            vxdiskService.save(vxdisk);
					        }
		            		if (!Status.equals("SVM") && !Status.equals("online") && !Status.equals("online clone_disk")) {
		            			String Problem ="Disk offline";
		            			Long ID;
			    				String IdString = datestr+timestr+indicedeprob;
			    				ID=Long.parseLong(IdString);
			    				OssProblems ossproblems= new OssProblems();
			    				ossproblems.setProblemid(ID);
			    				ossproblems.setProblem(Problem);
			    				ossproblems.setMail_send_to("s.saoudi09@gmail.com");
			    				ossproblems.setProblem_source(fichier[i].getPath());
			    				OssProblemsService.update(ossproblems);

				    			List<OssProblems> ossproblemssolutions =OssProblemsService.findS(Problem);
				    			
				    			MailingProblems MailProblem=new MailingProblems();
				    			MailProblem.SendMailVxdisk(ID,Status, Disk, fichier[i], ossproblemssolutions,Problem,session);
				    			indicedeprob++;
				    		}
				            line = br.readLine();
						}
					}	
					//--------------------- END Commande vxdisk -----------------------------------
					
					//--------------------- Commande prtdiag -v ---------------------------------------
					if (line.indexOf("start command prtdiag -v")!= -1) {
						int PS=0;
						int MDS=0;
						int US=0;
						System.out.println("yes");
						
						line = br.readLine();

						while (line.indexOf("end command prtdiag -v")== -1) {
							//line=br.readLine();
			            	if(line.indexOf("Version                          Location Tag")!= -1) {
								br.readLine();
								line=br.readLine();
								PS=1;
								MDS=0;
								US=0;
							}
			            	if(line.indexOf("Type    Status Set Device Locator      Bank Locator")!= -1) {
								br.readLine();
								line=br.readLine();
								PS=0;
								MDS=1;
								US=0;
							}
			            	if(line.indexOf("ID  Status    Type             Description")!= -1) {
								br.readLine();
								line=br.readLine();
								PS=0;
								MDS=0;
								US=1;
							}
							StringTokenizer st = new StringTokenizer(line);
				            ArrayList<String> Att= new ArrayList<String>();
				            while (st.hasMoreElements()) {
				            	Att.add(st.nextElement().toString());
				            }
				            if(Att.size()==9 && PS==1) {
				            	PrtdiagPS.setVersion(Att.get(0).toString()+" "+Att.get(1).toString()+" "+Att.get(2).toString()+" "+Att.get(3).toString()+" "+Att.get(4).toString());
			        			PrtdiagPS.setLocationTag(Att.get(5).toString()+" "+Att.get(6).toString()+" "+Att.get(7).toString()+" "+Att.get(8).toString()); 
					            PrtdiagPS.setDate(date);
					            PrtdiagPS.setTime(tm);
					            //PrtdiagPSService.save(PrtdiagPS);
					            System.out.println(PrtdiagPS.getVersion());
					            System.out.println(PrtdiagPS.getLocationTag());
					        }
				            if(Att.size()>=7 && MDS==1) {
				            	if (Att.size()==7) {
					            	PrtdiagMDS.setType(Att.get(0).toString());
				        			PrtdiagMDS.setStatus(Att.get(1).toString());
				        			PrtdiagMDS.setSet(Att.get(2).toString());
				        			PrtdiagMDS.setDeviceLocator(Att.get(3).toString()+" "+Att.get(4).toString()+" "+Att.get(5).toString()+" "+Att.get(6).toString());
				        			PrtdiagMDS.setDate(date);
						            PrtdiagMDS.setTime(tm);
						            //PrtdiagMDSService.save(PrtdiagMDS);
						            System.out.println(PrtdiagMDS.getType());
						            System.out.println(PrtdiagMDS.getStatus());
						            System.out.println(PrtdiagMDS.getSet());
						            System.out.println(PrtdiagMDS.getDeviceLocator());
				            	}
				            	if (Att.size()==8) {
					            	PrtdiagMDS.setType(Att.get(0).toString());
				        			PrtdiagMDS.setStatus(Att.get(1).toString()+" "+Att.get(2).toString());
				        			PrtdiagMDS.setSet(Att.get(3).toString());
				        			PrtdiagMDS.setDeviceLocator(Att.get(4).toString()+" "+Att.get(5).toString()+" "+Att.get(6).toString()+" "+Att.get(7).toString());
				        			PrtdiagMDS.setDate(date);
						            PrtdiagMDS.setTime(tm);
						            //PrtdiagMDSService.save(PrtdiagMDS);
						            System.out.println(PrtdiagMDS.getType());
						            System.out.println(PrtdiagMDS.getStatus());
						            System.out.println(PrtdiagMDS.getSet());
						            System.out.println(PrtdiagMDS.getDeviceLocator());
						            System.out.println(PrtdiagMDS.getBankLocator());
				            	}
					        }
				            
				            if(Att.size()>=8 && US==1) {
				            	if (Att.size()==8) {
					            	PrtdiagUS.setID(Att.get(0).toString());
				        			PrtdiagUS.setStatus(Att.get(1).toString());
				        			PrtdiagUS.setType(Att.get(2).toString()+" "+Att.get(3).toString()+" "+Att.get(4).toString());
				        			PrtdiagUS.setDescription(Att.get(5).toString()+" "+Att.get(6).toString()+" "+Att.get(7).toString());
				        			PrtdiagUS.setDate(date);
						            PrtdiagUS.setTime(tm);
						            //PrtdiagMDSService.save(PrtdiagUS);
						            System.out.println(PrtdiagUS.getID());
						            System.out.println(PrtdiagUS.getStatus());
						            System.out.println(PrtdiagUS.getType());
						            System.out.println(PrtdiagUS.getDescription());
						            System.out.println(PrtdiagUS.getDate());
						            System.out.println(PrtdiagUS.getTime());
				            	}
				            	if (Att.size()==9) {
					            	PrtdiagUS.setID(Att.get(0).toString());
				        			PrtdiagUS.setStatus(Att.get(1).toString()+" "+Att.get(2).toString());
				        			PrtdiagUS.setType(Att.get(3).toString()+" "+Att.get(4).toString()+" "+Att.get(5).toString());
				        			PrtdiagUS.setDescription(Att.get(6).toString()+" "+Att.get(7).toString()+" "+Att.get(8).toString());
				        			PrtdiagUS.setDate(date);
						            PrtdiagUS.setTime(tm);
						            //PrtdiagMDSService.save(PrtdiagUS);
						            System.out.println(PrtdiagUS.getID());
						            System.out.println(PrtdiagUS.getStatus());
						            System.out.println(PrtdiagUS.getType());
						            System.out.println(PrtdiagUS.getDescription());
						            System.out.println(PrtdiagUS.getDate());
						            System.out.println(PrtdiagUS.getTime());
				            	}
					        }
				            line = br.readLine();
						}
					}	
					//--------------------- END Commande prtdiag -v  -----------------------------------
					
					
					
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
												ossproblems.setMail_send_to("s.saoudi09@gmail.com");
												ossproblems.setProblem_source(fichier[i].getPath());
												OssProblemsService.update(ossproblems);
												String messagetext="Dear user," +"\n"+"problem name :smtool_problem:offline"+"\n problem id:"+ossproblems.getProblemid()+
																					"\n\n the state of application "+ a + " is :"+ b+", please try to make things right!"+"\n\n"+"those are some solutions : ";
												List<OssProblems> ossproblemssolution =OssProblemsService.findS(paramvalue);
												if (ossproblemssolution.isEmpty()) {
													ossproblemssolution = new ArrayList<OssProblems>();
												}else{
													for(OssProblems hadsolution :ossproblemssolution) {
														String [] solution = new String[4];
														solution[k]=hadsolution.getProposed_solution();
														messagetext=messagetext+"\n\n"+solution[k];
														k++;
														}}
												Message message = new MimeMessage(session);
												message.setFrom(new InternetAddress("OSS.Problems@gmail.com"));
												message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("s.saoudi09@gmail.com"));
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
												//Transport.send(message);
												indicedeprob ++;
											}catch (MessagingException e){
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
										//SvcsService.update(svcs);
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
	    	}finally {
	    		try{
	    			if (br != null)
	    				br.close();
	    		}catch (IOException ex) {
	    			ex.printStackTrace();
	    		}
	    	}
	    	
	    }

	}
}



