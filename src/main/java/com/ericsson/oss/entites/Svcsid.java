package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class Svcsid implements Serializable{
	private String fmri ;
	 private Date date ;
	 private Date time ;
	 protected Svcsid()
	 {}
		public Svcsid( String fmri,Date date,Date time ) {
				this.fmri =fmri;
				this.date=date;
				this.time=time;
			}
	public String getFmri() {
		return fmri;
	}
	public void setFmri(String fmri) {
		this.fmri = fmri;
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
