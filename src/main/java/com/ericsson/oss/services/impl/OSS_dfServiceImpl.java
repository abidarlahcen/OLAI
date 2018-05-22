package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IOSS_dfDao;
import com.ericsson.oss.entites.OSS_df;
import com.ericsson.oss.services.IOSS_dfService;

@Transactional
public class OSS_dfServiceImpl implements IOSS_dfService{
	
private IOSS_dfDao dao;
	
	public void setDao(IOSS_dfDao dao) {
		this.dao= dao;
	}

	@Override
	public OSS_df save(OSS_df entity) {
		return dao.save(entity);
	}

	@Override
	public OSS_df update(OSS_df entity) {
		return dao.update(entity);
	}

	@Override
	public List<OSS_df> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<OSS_df> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField,sort);
	}

	@Override
	public OSS_df getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public OSS_df findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public OSS_df findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName,paramValue);
	}
	

}
