package com.ericsson.oss;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert {
	
	public static void main(String[] args) {
		String str="12-00";
		Convert cnv= new Convert();
		Date a= cnv.ConvertTime(str);
		System.out.println(a);
	}
	
    public float ConvertPercentage(String str) {
		
    	String[] st= str.split("%");
    	float n = Float.parseFloat( st[0] );
    	return n/100;

	    }
    
    public double ConvertTo(String str) {

		int M=0;
		int K=0;
		int G=0;
		double n=0;
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'M') {
				M=1;
				String[] st= str.split("M");
			    n = Double.parseDouble(st[0]);
				n = n*Math.pow(10,6);
								
			}}
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'G') {
				G=1;
				String[] st= str.split("G");
				n = Double.parseDouble(st[0]);
				n = n*Math.pow(10,9);
			}}
		
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'K') {
				K=1;
				String[] st= str.split("K");
				n = Double.parseDouble(st[0]);
				n = n*Math.pow(10,3);
			}}	
		
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'O') {
				K=1;
				String[] st= str.split("O");
				n = Double.parseDouble(st[0]);
			}}	
    	
    	return n;

	    }
    public java.sql.Date ConvertDate(String date) {
    	Date dt=new Date();
    	java.sql.Date dte=new java.sql.Date(dt.getDate());
    	try {
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			dt=dateFormat.parse(date);
			dte=new java.sql.Date(dt.getDate());
			
		}catch (ParseException e) {
			e.printStackTrace();
		}
    	return dte;
    }
    public java.sql.Time ConvertTime(String time) {
    	Date dt=new Date();
		java.sql.Time tm= new java.sql.Time(dt.getTime());

    	try {
			DateFormat dateFormat = new SimpleDateFormat("HH-mm");
			dt=dateFormat.parse(time);
			tm = new java.sql.Time(dt.getTime());
		}catch (ParseException e) {
			e.printStackTrace();
		}
    	return tm;
    }
    
    
}
