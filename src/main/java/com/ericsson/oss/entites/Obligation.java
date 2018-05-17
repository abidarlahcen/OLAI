package com.ericsson.oss.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Obligation implements Serializable{
	@Id
	private String code_maroclear;
	private String type;
	private String emet;
	
	

}
