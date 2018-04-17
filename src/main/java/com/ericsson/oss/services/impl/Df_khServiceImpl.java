package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IDf_khDao;
import com.ericsson.oss.entites.Df_kh;
import com.ericsson.oss.services.IDf_khService;

@Transactional 
public class Df_khServiceImpl  implements IDf_khService {
	
	private IDf_khDao dao;
	
	public void setDao(IDf_khDao dao) {
		this.dao = dao;
	}

	@Override
	public Df_kh save(Df_kh entity) {
		return dao.save(entity);
	}

	@Override
	public Df_kh update(Df_kh entity) {
		return dao.update(entity);
	}

	@Override
	public List<Df_kh> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Df_kh> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Df_kh getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Df_kh findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Df_kh findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}
}
 
