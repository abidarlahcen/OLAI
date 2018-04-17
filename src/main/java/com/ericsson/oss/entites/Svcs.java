package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 

public class Svcs implements Serializable {
 Svcsid svcsid ;
 
 

private Date stime ;
@Id
 public Svcsid getSvcsid() {
	return svcsid;
}

public void setSvcsid(Svcsid svcsid) {
	this.svcsid = svcsid;
}

private String state ;
 
 public Svcs () { 
 }



public Date getStime() {
	return stime;
}

public void setStime(Date stime) {
	this.stime = stime;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}
 
 }
