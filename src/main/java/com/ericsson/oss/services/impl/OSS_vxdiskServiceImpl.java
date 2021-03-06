package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IOSS_vxdiskDao;
import com.ericsson.oss.entites.OSS_vxdisk;
import com.ericsson.oss.services.IOSS_vxdiskService;

@Transactional
public class OSS_vxdiskServiceImpl implements IOSS_vxdiskService {

	private IOSS_vxdiskDao dao;
	
	public void setDao(IOSS_vxdiskDao dao) {
		this.dao= dao;
	}

	@Override
	public OSS_vxdisk save(OSS_vxdisk entity) {
		return dao.save(entity);
	}

	@Override
	public OSS_vxdisk update(OSS_vxdisk entity) {
		return dao.update(entity);
	}

	@Override
	public List<OSS_vxdisk> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<OSS_vxdisk> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField,sort);
	}

	@Override
	public OSS_vxdisk getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public OSS_vxdisk findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public OSS_vxdisk findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName,paramValue);
	}
	

}
