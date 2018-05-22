package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.Df_kh_Seuil;

public interface IDf_kh_SeuilService {
	public Df_kh_Seuil save(Df_kh_Seuil entity);
	
	public Df_kh_Seuil update(Df_kh_Seuil entity);
	
	public List<Df_kh_Seuil> selectAll();
	
	public List<Df_kh_Seuil> selectAll(String sortFiDeld, String sort);
	
	public Df_kh_Seuil getById(Long id);
	
	public void remove(Long id);
	
	public Df_kh_Seuil findOne(String paramName, Object paramValue);
	
	public Df_kh_Seuil findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
