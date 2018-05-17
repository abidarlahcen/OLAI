package com.ericsson.oss.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "groups_online")
public class Hatool implements Serializable {
Hatoolid hatoolid ;

private String []  groups_online;
private String []  groups_offline;
private String []  groups_partial;
public Hatool () {}
@Id
public Hatoolid getHatoolid() {
	return hatoolid;
}
public void setHatoolid(Hatoolid hatoolid) {
	this.hatoolid = hatoolid;
}
public String[] getGroups_online() {
	return groups_online;
}
public void setGroups_online(String[] groups_online) {
	this.groups_online = groups_online;
}
public String[] getGroups_offline() {
	return groups_offline;
}
public void setGroups_offline(String[] groups_offline) {
	this.groups_offline = groups_offline;
}
public String[] getGroups_partial() {
	return groups_partial;
}
public void setGroups_partial(String[] groups_partial) {
	this.groups_partial = groups_partial;
}

}
