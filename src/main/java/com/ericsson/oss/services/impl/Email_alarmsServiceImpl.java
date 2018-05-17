package com.ericsson.oss.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IEmail_alarmsDao;
import com.ericsson.oss.entites.Email_alarms;
import com.ericsson.oss.entites.OssProblems;
import com.ericsson.oss.services.IEmail_alarmsService;

@Transactional 
public class Email_alarmsServiceImpl  implements IEmail_alarmsService {
	@PersistenceContext
	EntityManager em;
	private IEmail_alarmsDao dao;
	
	public void setDao(IEmail_alarmsDao dao) {
		this.dao = dao;
	}

	@Override
	public Email_alarms save(Email_alarms entity) {
		return dao.save(entity);
	}

	@Override
	public Email_alarms update(Email_alarms entity) {
		return dao.update(entity);
	}

	@Override
	public List<Email_alarms> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Email_alarms> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Email_alarms getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Email_alarms findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Email_alarms findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
    public List<Email_alarms> findObject(String  paramValue) {
		
		
		Query query = em.createQuery("select t from Email_alarms t where t.idemail_alarms.object LIKE :x");
		query.setParameter("x", paramValue);
		return query.getResultList();
		}
}
