package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Id;
@Embeddable
public class Smtoolid implements Serializable {
	/**
	 * 
	 */

	private String application ;
	private Date date ;
	private Date time ;
	protected Smtoolid(){}
	public Smtoolid( String application,Date date,Date time ) {
			this.setApplication(application);
			this.setDate(date);
			this.setTime(time);
		}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
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
