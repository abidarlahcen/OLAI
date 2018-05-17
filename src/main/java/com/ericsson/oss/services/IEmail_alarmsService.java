package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.Email_alarms;

public interface IEmail_alarmsService {
public Email_alarms save(Email_alarms entity);
	
	public Email_alarms update(Email_alarms entity);
	
	public List<Email_alarms> selectAll();
	
	public List<Email_alarms> selectAll(String sortFiDeld, String sort);
	
	public Email_alarms getById(Long id);
	
	public void remove(Long id);
	
	public Email_alarms findOne(String paramName, Object paramValue);
	
	public Email_alarms findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	public List<Email_alarms> findObject(String  paramValue);
}
