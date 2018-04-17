package com.ericsson.oss.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Dmr_dmtool implements Serializable {
	Dmtoolid Dmtoolid ;
  


private String mirror_1 ;
private String mirror_2 ;


public Dmr_dmtool() {
	
}
@Id
public Dmtoolid getDmtoolid() {
	return Dmtoolid;
}

public void setDmtoolid(Dmtoolid dmtoolid) {
	Dmtoolid = dmtoolid;
}

public String getMirror_1() {
	return mirror_1;
}

public void setMirror_1(String mirror_1) {
	this.mirror_1 = mirror_1;
}

public String getMirror_2() {
	return mirror_2;
}

public void setMirror_2(String mirror_2) {
	this.mirror_2 = mirror_2;
}


}
