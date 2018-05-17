package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IDmr_dmtoolDao;
import com.ericsson.oss.entites.Dmr_dmtool;
import com.ericsson.oss.services.IDmr_dmtoolService;

@Transactional 
public class Dmr_dmtoolServiceImpl implements IDmr_dmtoolService {
	
	private IDmr_dmtoolDao dao;
	
	public void setDao(IDmr_dmtoolDao dao) {
		this.dao = dao;
	}

	@Override
	public Dmr_dmtool save(Dmr_dmtool entity) {
		return dao.save(entity);
	}

	@Override
	public Dmr_dmtool update(Dmr_dmtool entity) {
		return dao.update(entity);
	}

	@Override
	public List<Dmr_dmtool> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Dmr_dmtool> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Dmr_dmtool getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dmr_dmtool findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dmr_dmtool findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}



}
