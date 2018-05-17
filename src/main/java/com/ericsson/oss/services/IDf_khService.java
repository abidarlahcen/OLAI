package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.Df_kh;

public interface IDf_khService {
public Df_kh save(Df_kh entity);
	
	public Df_kh update(Df_kh entity);
	
	public List<Df_kh> selectAll();
	
	public List<Df_kh> selectAll(String sortFiDeld, String sort);
	
	public Df_kh getById(Long id);
	
	public void remove(Long id);
	
	public Df_kh findOne(String paramName, Object paramValue);
	
	public Df_kh findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
