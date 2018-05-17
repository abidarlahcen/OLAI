package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IHatoolDao;
import com.ericsson.oss.entites.Hatool;
import com.ericsson.oss.services.IHatoolService;

@Transactional 
public class HatoolServiceImpl  implements IHatoolService {
	
	private IHatoolDao dao;
	
	public void setDao(IHatoolDao dao) {
		this.dao = dao;
	}

	@Override
	public Hatool save(Hatool entity) {
		return dao.save(entity);
	}

	@Override
	public Hatool update(Hatool entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hatool> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hatool> selectAll(String sortFiDeld, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hatool getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hatool findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hatool findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}
}
