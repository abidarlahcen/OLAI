package com.ericsson.oss.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.IOssProblemsDao;
import com.ericsson.oss.entites.OssProblems;
import com.ericsson.oss.services.IOssProblemsService;
@Transactional
public class OssProblemsServiceImpl implements IOssProblemsService{
	@PersistenceContext
	EntityManager em;
	
	private Class<OssProblems> type;
private IOssProblemsDao dao;
	
	public void setDao(IOssProblemsDao dao) {
		this.dao = dao;
	}

	@Override
	public OssProblems save(OssProblems entity) {
		return dao.save(entity);
	}

	@Override
	public OssProblems update(OssProblems entity) {
		return dao.update(entity);
	}

	@Override
	public List<OssProblems> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<OssProblems> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public OssProblems getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OssProblems findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OssProblems findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
    public List<OssProblems> findS(String  paramValue) {
		
		
		Query query = em.createQuery("select t from OssProblems t where t.problem LIKE :x");
		query.setParameter("x", paramValue);
		return query.getResultList();
		}
	@Override
    public List<OssProblems> findproblemsnotresol() {
	Query query = em.createQuery("select t from OssProblems t where t.proposed_solution IS NULL ");
		
		return query.getResultList();
		}
	
        
}
