package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.Svcs;

public interface ISvcsService {
    public Svcs save(Svcs entity);
	
	public Svcs update(Svcs entity);
	
	public List<Svcs> selectAll();
	
	public List<Svcs> selectAll(String sortField, String sort);
	
	public Svcs getById(Long id);
	
	public void remove(Long id);
	
	public Svcs findOne(String paramName, Object paramValue);
	
	public Svcs findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
