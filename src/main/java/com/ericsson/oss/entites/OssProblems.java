package com.ericsson.oss.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity 
public class OssProblems implements Serializable{
	@Id  private Long  problemid;
private String problem ;
private String mail_send_to ;
private String proposed_solution;
private String problem_source;


public Long getProblemid() {
	return problemid;
}
public void setProblemid(Long problemid) {
	this.problemid = problemid;
}
public String getProblem() {
	return problem;
}
public void setProblem(String problem) {
	this.problem = problem;
}
public String getMail_send_to() {
	return mail_send_to;
}
public void setMail_send_to(String mail_send_to) {
	this.mail_send_to = mail_send_to;
}
public String getProposed_solution() {
	return proposed_solution;
}
public void setProposed_solution(String proposed_solution) {
	this.proposed_solution = proposed_solution;
}
public String getProblem_source() {
	return problem_source;
}
public void setProblem_source(String problem_source) {
	this.problem_source = problem_source;
}


}
