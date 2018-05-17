package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.Hatool;

public interface IHatoolService {
public Hatool save(Hatool entity);
	
	public Hatool update(Hatool entity);
	
	public List<Hatool> selectAll();
	
	public List<Hatool> selectAll(String sortFiDeld, String sort);
	
	public Hatool getById(Long id);
	
	public void remove(Long id);
	
	public Hatool findOne(String paramName, Object paramValue);
	
	public Hatool findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
