package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IOSSPrtdiagPSDao;
import com.ericsson.oss.entites.OSSPrtdiagPS;
import com.ericsson.oss.services.IOSSPrtdiagPSService;

@Transactional
public class OSSPrtdiagPSServiceImpl implements IOSSPrtdiagPSService{
	
private IOSSPrtdiagPSDao dao;
	
	public void setDao(IOSSPrtdiagPSDao dao) {
		this.dao= dao;
	}

	@Override
	public OSSPrtdiagPS save(OSSPrtdiagPS entity) {
		return dao.save(entity);
	}

	@Override
	public OSSPrtdiagPS update(OSSPrtdiagPS entity) {
		return dao.update(entity);
	}

	@Override
	public List<OSSPrtdiagPS> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<OSSPrtdiagPS> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField,sort);
	}

	@Override
	public OSSPrtdiagPS getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public OSSPrtdiagPS findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public OSSPrtdiagPS findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName,paramValue);
	}
	

}
