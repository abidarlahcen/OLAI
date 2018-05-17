package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.OssProblems;

public interface IOssProblemsService {
public OssProblems save(OssProblems entity);
	
	public OssProblems update(OssProblems entity);
	
	public List<OssProblems> selectAll();
	
	public List<OssProblems> selectAll(String sortField, String sort);
	
	public OssProblems getById(Long id);
	
	public void remove(Long id);
	
	public OssProblems findOne(String paramName, Object paramValue);
	
	public OssProblems findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	public List<OssProblems> findS(String paramValue);
	public List<OssProblems> findproblemsnotresol();
	public List<OssProblems> findproblemsresol() ;
}
