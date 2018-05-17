package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.Smtool_list;

public interface ISmtool_listService {
public Smtool_list save(Smtool_list entity);
	
	public Smtool_list update(Smtool_list entity);
	
	public List<Smtool_list> selectAll();
	
	public List<Smtool_list> selectAll(String sortField, String sort);
	
	public Smtool_list getById(Long id);
	
	public void remove(Long id);
	
	public Smtool_list findOne(String paramName, Object paramValue);
	
	public Smtool_list findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
