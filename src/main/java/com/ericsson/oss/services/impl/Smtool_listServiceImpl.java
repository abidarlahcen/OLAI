package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.ISmtool_listDao;
import com.ericsson.oss.entites.Smtool_list;
import com.ericsson.oss.services.ISmtool_listService;

@Transactional 
public class Smtool_listServiceImpl implements ISmtool_listService {
	
	private ISmtool_listDao dao;
	
	public void setDao(ISmtool_listDao dao) {
		this.dao = dao;
	}

	@Override
	public Smtool_list save(Smtool_list entity) {
		return dao.save(entity);
	}

	@Override
	public Smtool_list update(Smtool_list entity) {
		return dao.update(entity);
	}

	@Override
	public List<Smtool_list> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Smtool_list> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Smtool_list getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Smtool_list findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Smtool_list findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}
}