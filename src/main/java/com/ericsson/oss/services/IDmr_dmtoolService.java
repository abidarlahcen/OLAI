package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.Dmr_dmtool;

public interface IDmr_dmtoolService {
public Dmr_dmtool save(Dmr_dmtool entity);
	
	public Dmr_dmtool update(Dmr_dmtool entity);
	
	public List<Dmr_dmtool> selectAll();
	
	public List<Dmr_dmtool> selectAll(String sortField, String sort);
	
	public Dmr_dmtool getById(Long id);
	
	public void remove(Long id);
	
	public Dmr_dmtool findOne(String paramName, Object paramValue);
	 
	public Dmr_dmtool findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
