package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OSSPrtdiagPS implements Serializable {

	    @Id
		private Date Date;
	    @Id
		private java.sql.Time Time; 
		@NotNull
		private String Version;
		@Id
		private String LocationTag;
		
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
		public String getVersion() {
			return Version;
		}
		public void setVersion(String version) {
			Version = version;
		}
		public String getLocationTag() {
			return LocationTag;
		}
		public void setLocationTag(String locationTag) {
			LocationTag = locationTag;
		}
		
		
}

