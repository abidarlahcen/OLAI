package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OSS_vxdisk implements Serializable {
	@Id
	private Date Date;
    @Id
	private java.sql.Time Time; 
	@Id 
	private String Device;
	@NotNull 
	private String Type;
	@NotNull 
	private String Disk;
	@NotNull 
	private String Groupe;
	@NotNull 
	private String Status;
	
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public java.sql.Time getTime() {
		return Time;
	}
	public void setTime(java.sql.Time time) {
		Time = time;
	}
	public String getDevice() {
		return Device;
	}
	public void setDevice(String device) {
		Device = device;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDisk() {
		return Disk;
	}
	public void setDisk(String disk) {
		Disk = disk;
	}
	public String getGroup() {
		return Groupe;
	}
	public void setGroup(String group) {
		Groupe = group;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

}
