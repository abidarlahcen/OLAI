package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
public class Hatoolid implements Serializable{
	
	private Date date;
	private Date time ;
	protected Hatoolid(){}
public Hatoolid( Date date,Date time ) {
		
		this.date=date;
		this.time=time;
	}

public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
			 
			
			
}
