package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OSS_df implements Serializable {

	    @Id
		private Date Date;
	    @Id
		private java.sql.Time Time; 
		@NotNull
		private String filesystem;
		@NotNull
		private Double size;
		@NotNull
		private Double used;
		@NotNull
		private Double avail;
		@NotNull
		private Float capacity;
		@Id
		private String mounted_on;
		
		public Date getDate() {
			return Date;
		}
		public void setDate(Date date) {
			Date = date;
		}
		public String getFilesystem() {
			return filesystem;
		}
		public void setFilesystem(String filesystem) {
			this.filesystem = filesystem;
		}
		public Double getSize() {
			return size;
		}
		public void setSize(Double size) {
			this.size = size;
		}
		public Double getUsed() {
			return used;
		}
		public void setUsed(Double used) {
			this.used = used;
		}
		public Double getAvail() {
			return avail;
		}
		public void setAvail(Double avail) {
			this.avail = avail;
		}
		public Float getCapacity() {
			return capacity;
		}
		public void setCapacity(Float capacity) {
			this.capacity = capacity;
		}
		public String getMounted_on() {
			return mounted_on;
		}
		public void setMounted_on(String mounted_on) {
			this.mounted_on = mounted_on;
		}	
		public java.sql.Time getTime() {
			return Time;
		}
		public void setTime(java.sql.Time time) {
			Time = time;
		}
}

