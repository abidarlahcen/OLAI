package com.ericsson.oss;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class fait {
	public static void main(String[] args) throws ParseException {

		BufferedReader br = null;

		
		
		try {

			String line;

			br = new BufferedReader(new FileReader("C:\\Users\\user\\Downloads\\log\\OSS_LOG_DAILY.txt"));
			 String nameOfLog =br.readLine().toString();
			 System.out.println("name of log : " +nameOfLog);
				if (nameOfLog.indexOf("/dmr/dmtool")!= -1){
					line = br.readLine();
					line = br.readLine();
					
					Date date = new Date() ;
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					date=df.parse(line = br.readLine());
			while ((line = br.readLine()) != null) {
			
if (line.indexOf("Diskgroup/Volume")!= -1) {
					br.readLine();
				String ligne = br.readLine();
				if (ligne!= null) {
			
				while (ligne.indexOf("Defined")== -1) {
					
				String lo=ligne.trim();
				Scanner sc =new Scanner(lo);
			   String a="a";
               String b="b";
			   String c="c";
			   while (sc.hasNextLine()) {
				               
							
							  a=sc.next().toString();
							  if (sc.hasNext()) {
							  b=sc.next().toString();}
							  if (sc.hasNext()) {
							  c=sc.next().toString();}
			                
							 
			   System.out.println("\na : " + a);
				System.out.println("\nb : " + b);
				System.out.println("\nc : " + c);
				System.out.println("\nla date : " + date);
			   }
			   ligne = br.readLine();
			   }
		}
				}
				
			}
				}
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
			
		
