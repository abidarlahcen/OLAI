package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.Isql_usa;

public interface Iisql_usaService {
public Isql_usa save(Isql_usa entity);
	
	public Isql_usa update(Isql_usa entity);
	
	public List<Isql_usa> selectAll();
	
	public List<Isql_usa> selectAll(String sortFiDeld, String sort);
	
	public Isql_usa getById(Long id);
	
	public void remove(Long id);
	
	public Isql_usa findOne(String paramName, Object paramValue);
	
	public Isql_usa findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}