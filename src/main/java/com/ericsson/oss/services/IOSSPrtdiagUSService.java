package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.OSSPrtdiagUS;

public interface IOSSPrtdiagUSService {
	
	public OSSPrtdiagUS save(OSSPrtdiagUS entity);
	
	public OSSPrtdiagUS update(OSSPrtdiagUS entity);
	
	public List<OSSPrtdiagUS> selectAll();
	
	public List<OSSPrtdiagUS> selectAll(String sortField, String sort);
	
	public OSSPrtdiagUS getById(Long id);
	
	public void remove(Long id);
	
	public OSSPrtdiagUS findOne(String paramName, Object paramValue);
	
	public OSSPrtdiagUS findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
