package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IObligationDao;
import com.ericsson.oss.entites.Obligation;
import com.ericsson.oss.services.IObligationService;

@Transactional 
public class ObligationServiceImpl  implements IObligationService {
	
	private IObligationDao dao;
	
	public void setDao(IObligationDao dao) {
		this.dao = dao;
	}

	@Override
	public Obligation save(Obligation entity) {
		return dao.save(entity);
	}

	@Override
	public Obligation update(Obligation entity) {
		return dao.update(entity);
	}

	@Override
	public List<Obligation> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Obligation> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Obligation getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Obligation findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Obligation findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}
}
