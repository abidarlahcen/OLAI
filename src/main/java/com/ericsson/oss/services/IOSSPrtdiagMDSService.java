package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.OSSPrtdiagMDS;

public interface IOSSPrtdiagMDSService {
	
	public OSSPrtdiagMDS save(OSSPrtdiagMDS entity);
	
	public OSSPrtdiagMDS update(OSSPrtdiagMDS entity);
	
	public List<OSSPrtdiagMDS> selectAll();
	
	public List<OSSPrtdiagMDS> selectAll(String sortField, String sort);
	
	public OSSPrtdiagMDS getById(Long id);
	
	public void remove(Long id);
	
	public OSSPrtdiagMDS findOne(String paramName, Object paramValue);
	
	public OSSPrtdiagMDS findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
