package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class Isql_usaid implements Serializable{
	private Date date;
	private Date time ;
	protected Isql_usaid (){}
public Isql_usaid( Date date,Date time ) {
		
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
