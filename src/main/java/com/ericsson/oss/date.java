package com.ericsson.oss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.ericsson.oss.entites.Dmr_dmtool;
import com.ericsson.oss.services.IDmr_dmtoolService;

public class date {
	@Autowired 
	private IDmr_dmtoolService Dmr_dmtoolService ;
	public static void main(String[] args)  throws ParseException {
		
		
		  BufferedReader br = null;
		  
		  
		  
			try {

				String line;

				br = new BufferedReader(new FileReader("C:\\Users\\user\\Downloads\\log\\date.txt"));
				 String nameOfLog =br.readLine().toString();
				 
					

				 nameOfLog = nameOfLog.replace("Last login: ", "");
				 
						Date date = new Date() ;
						DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy",Locale.ENGLISH);
						date=df.parse(nameOfLog);
						System.out.println(date);
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

