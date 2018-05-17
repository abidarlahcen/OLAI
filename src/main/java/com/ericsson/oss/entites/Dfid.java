package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class Dfid implements Serializable {
		 
		private String mounted_on;
		private Date date;
		private Date time ;
		protected Dfid(){}
	public Dfid( String mounted_on,Date date,Date time ) {
			this.mounted_on =mounted_on;
			this.date=date;
			this.time=time;
		}
		public String getMounted_on() {
			return mounted_on;
		}
		public void setMounted_on(String mounted_on) {
			this.mounted_on = mounted_on;
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
