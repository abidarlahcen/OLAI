package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OSSPrtdiagMDS implements Serializable {

	    @Id
		private Date Date;
	    @Id
		private java.sql.Time Time; 
		@NotNull
		private String Type;
		@NotNull
		private String Status;
		@NotNull
		private String SetNb;
		@Id
		private String DeviceLocator;
		private String BankLocator;
		
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
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			Type = type;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getSet() {
			return SetNb;
		}
		public void setSet(String set) {
			SetNb = set;
		}
		public String getDeviceLocator() {
			return DeviceLocator;
		}
		public void setDeviceLocator(String deviceLocator) {
			DeviceLocator = deviceLocator;
		}
		public String getBankLocator() {
			return BankLocator;
		}
		public void setBankLocator(String bankLocator) {
			BankLocator = bankLocator;
		}
		
}

