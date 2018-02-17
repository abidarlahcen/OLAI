package com.ericsson.oss.services.impl;

import java.io.InputStream;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IFlickrDao;
import com.ericsson.oss.services.IFlickrService;

@Transactional
public class FlickrServiceImpl implements IFlickrService {
	
	private IFlickrDao dao;
	
	public void setDao(IFlickrDao dao) {
		this.dao = dao;
	}

	@Override
	public String savePhoto(InputStream photo, String title) throws Exception {
		return dao.savePhoto(photo, title);
	}

}
