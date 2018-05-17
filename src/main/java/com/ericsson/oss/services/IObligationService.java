package com.ericsson.oss.services;

import java.util.List;

import com.ericsson.oss.entites.Obligation;

public interface IObligationService {
public Obligation save(Obligation entity);
	
	public Obligation update(Obligation entity);

	public List<Obligation> selectAll();

	public List<Obligation> selectAll(String sortField, String sort);

	public Obligation getById(Long id);

	public void remove(Long id);

	public Obligation findOne(String paramName, Object paramValue);

	public Obligation findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);
}
