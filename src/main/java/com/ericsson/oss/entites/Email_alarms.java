package com.ericsson.oss.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Email_alarms")
public class Email_alarms implements Serializable{
	private String position;
	private String company ;
	Idemail_alarms idemail_alarms ;
	public Email_alarms () {
		
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Id
	public Idemail_alarms getIdemail_alarms() {
		return idemail_alarms;
	}
	public void setIdemail_alarms(Idemail_alarms idemail_alarms) {
		this.idemail_alarms = idemail_alarms;
	}
	
}
