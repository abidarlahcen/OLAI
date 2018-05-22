package com.ericsson.oss.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class LogName implements Serializable {

	@Id
	@GeneratedValue
	private Long idLogName;
	@NotNull
	private String LogName;
	public Long getIdLogName() {
		return idLogName;
	}
	public void setIdLogName(Long idLogName) {
		this.idLogName = idLogName;
	}
	public String getLogName() {
		return LogName;
	}
	public void setLogName(String logName) {
		LogName = logName;
	}
	
	
}
