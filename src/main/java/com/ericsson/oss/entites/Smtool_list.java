package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Smtool_list implements Serializable {
	
	private Smtoolid Smtoolid;
	private String state ;
	
	@Id
	public Smtoolid getSmtoolid() {
		return Smtoolid;
	}
	public void setSmtoolid(Smtoolid smtoolid) {
		Smtoolid = smtoolid;
	}
public Smtool_list () {}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
