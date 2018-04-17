package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable 
public class Dmtoolid implements Serializable{
	
	private String diskgroup_volume ;
	private Date  date ;
	private Date  time;
	protected Dmtoolid(){}
	public Dmtoolid( String diskgroup_volume,Date date,Date time ) {
			this.diskgroup_volume =diskgroup_volume;
			this.date=date;
			this.time=time;
		}
	public String getDiskgroup_volume() {
		return diskgroup_volume;
	}
	public void setDiskgroup_volume(String diskgroup_volume) {
		this.diskgroup_volume = diskgroup_volume;
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
