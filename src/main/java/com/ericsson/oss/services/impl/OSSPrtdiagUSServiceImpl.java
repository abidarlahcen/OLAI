package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IOSSPrtdiagUSDao;
import com.ericsson.oss.entites.OSSPrtdiagUS;
import com.ericsson.oss.services.IOSSPrtdiagUSService;

@Transactional
public class OSSPrtdiagUSServiceImpl implements IOSSPrtdiagUSService{
	
private IOSSPrtdiagUSDao dao;
	
	public void setDao(IOSSPrtdiagUSDao dao) {
		this.dao= dao;
	}

	@Override
	public OSSPrtdiagUS save(OSSPrtdiagUS entity) {
		return dao.save(entity);
	}

	@Override
	public OSSPrtdiagUS update(OSSPrtdiagUS entity) {
		return dao.update(entity);
	}

	@Override
	public List<OSSPrtdiagUS> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<OSSPrtdiagUS> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField,sort);
	}

	@Override
	public OSSPrtdiagUS getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public OSSPrtdiagUS findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public OSSPrtdiagUS findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName,paramValue);
	}
	

}
