package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.OSS_df;

public interface IOSS_dfService {
	
	public OSS_df save(OSS_df entity);
	
	public OSS_df update(OSS_df entity);
	
	public List<OSS_df> selectAll();
	
	public List<OSS_df> selectAll(String sortField, String sort);
	
	public OSS_df getById(Long id);
	
	public void remove(Long id);
	
	public OSS_df findOne(String paramName, Object paramValue);
	
	public OSS_df findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
