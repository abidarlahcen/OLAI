package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OSSPrtdiagUS implements Serializable {

	    @Id
		private Date Date;
	    @Id
		private java.sql.Time Time; 
		@Id
		private String ID;
		@NotNull
		private String Status;
		@NotNull
		private String Type;
		@NotNull
		private String Description;
		
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
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			Type = type;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}

	
		
		
}

