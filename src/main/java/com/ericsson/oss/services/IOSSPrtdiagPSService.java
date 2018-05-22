package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.OSSPrtdiagPS;

public interface IOSSPrtdiagPSService {
	
	public OSSPrtdiagPS save(OSSPrtdiagPS entity);
	
	public OSSPrtdiagPS update(OSSPrtdiagPS entity);
	
	public List<OSSPrtdiagPS> selectAll();
	
	public List<OSSPrtdiagPS> selectAll(String sortField, String sort);
	
	public OSSPrtdiagPS getById(Long id);
	
	public void remove(Long id);
	
	public OSSPrtdiagPS findOne(String paramName, Object paramValue);
	
	public OSSPrtdiagPS findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
