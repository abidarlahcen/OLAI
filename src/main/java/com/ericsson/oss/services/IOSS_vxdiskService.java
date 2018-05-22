package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.OSS_vxdisk;

public interface IOSS_vxdiskService {

	public OSS_vxdisk save(OSS_vxdisk entity);
	
	public OSS_vxdisk update(OSS_vxdisk entity);
	
	public List<OSS_vxdisk> selectAll();
	
	public List<OSS_vxdisk> selectAll(String sortField, String sort);
	
	public OSS_vxdisk getById(Long id);
	
	public void remove(Long id);
	
	public OSS_vxdisk findOne(String paramName, Object paramValue);
	
	public OSS_vxdisk findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
