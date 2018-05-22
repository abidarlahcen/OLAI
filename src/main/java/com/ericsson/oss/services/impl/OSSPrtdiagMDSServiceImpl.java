package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IOSSPrtdiagMDSDao;
import com.ericsson.oss.entites.OSSPrtdiagMDS;
import com.ericsson.oss.services.IOSSPrtdiagMDSService;

@Transactional
public class OSSPrtdiagMDSServiceImpl implements IOSSPrtdiagMDSService{
	
private IOSSPrtdiagMDSDao dao;
	
	public void setDao(IOSSPrtdiagMDSDao dao) {
		this.dao= dao;
	}

	@Override
	public OSSPrtdiagMDS save(OSSPrtdiagMDS entity) {
		return dao.save(entity);
	}

	@Override
	public OSSPrtdiagMDS update(OSSPrtdiagMDS entity) {
		return dao.update(entity);
	}

	@Override
	public List<OSSPrtdiagMDS> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<OSSPrtdiagMDS> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField,sort);
	}

	@Override
	public OSSPrtdiagMDS getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public OSSPrtdiagMDS findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public OSSPrtdiagMDS findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName,paramValue);
	}
	

}
