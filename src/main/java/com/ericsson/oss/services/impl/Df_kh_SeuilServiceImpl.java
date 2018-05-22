package com.ericsson.oss.services.impl;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.ericsson.oss.dao.IDf_kh_SeuilDao;
import com.ericsson.oss.entites.Df_kh_Seuil;
import com.ericsson.oss.services.IDf_kh_SeuilService;

@Transactional 
public class Df_kh_SeuilServiceImpl  implements IDf_kh_SeuilService {
	
	private IDf_kh_SeuilDao dao;
	
	public void setDao(IDf_kh_SeuilDao dao) {
		this.dao = dao;
	}

	@Override
	public Df_kh_Seuil save(Df_kh_Seuil entity) {
		return dao.save(entity);
	}

	@Override
	public Df_kh_Seuil update(Df_kh_Seuil entity) {
		return dao.update(entity);
	}

	@Override
	public List<Df_kh_Seuil> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Df_kh_Seuil> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Df_kh_Seuil getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Df_kh_Seuil findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Df_kh_Seuil findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}
}
 
