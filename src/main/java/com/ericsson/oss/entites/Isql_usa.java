package com.ericsson.oss.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Isql_usa implements Serializable{
private int Fma_alarm_list ;
private int Fma_alarm_log;
private int Fma_operator_log;
Isql_usaid isql_usaid;
public Isql_usa() {}
public int getFma_alarm_list() {
	return Fma_alarm_list;
}
public void setFma_alarm_list(int fma_alarm_list) {
	Fma_alarm_list = fma_alarm_list;
}
public int getFma_alarm_log() {
	return Fma_alarm_log;
}
public void setFma_alarm_log(int fma_alarm_log) {
	Fma_alarm_log = fma_alarm_log;
}
public int getFma_operator_log() {
	return Fma_operator_log;
}
public void setFma_operator_log(int fma_operator_log) {
	Fma_operator_log = fma_operator_log;
}
@Id
public Isql_usaid getIsql_usaid() {
	return isql_usaid;
}
public void setIsql_usaid(Isql_usaid isql_usaid) {
	this.isql_usaid = isql_usaid;
	
}

}
