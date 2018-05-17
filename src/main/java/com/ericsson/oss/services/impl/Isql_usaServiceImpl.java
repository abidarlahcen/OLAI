package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.Iisql_usaDao;
import com.ericsson.oss.entites.Isql_usa;
import com.ericsson.oss.services.Iisql_usaService;

@Transactional 
public class Isql_usaServiceImpl  implements Iisql_usaService {
	
	private Iisql_usaDao dao;
	
	public void setDao(Iisql_usaDao dao) {
		this.dao = dao;
	}

	@Override
	public Isql_usa save(Isql_usa entity) {
		return dao.save(entity);
	}

	@Override
	public Isql_usa update(Isql_usa entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Isql_usa> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Isql_usa> selectAll(String sortFiDeld, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Isql_usa getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Isql_usa findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Isql_usa findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}
}
