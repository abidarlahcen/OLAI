package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.ICategoryDao;
import com.ericsson.oss.entites.Article;
import com.ericsson.oss.entites.Category;
import com.ericsson.oss.services.ICategoryService;

@Transactional
public class CategoryServiceImpl implements ICategoryService {
	
	private ICategoryDao dao;
	
	public void setDao(ICategoryDao dao) {
		this.dao = dao;
	}

	@Override
	public Category save(Category entity) {
		return dao.save(entity);
	}

	@Override
	public Category update(Category entity) {
		return dao.update(entity);
	}

	@Override
	public List<Category> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Category> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Category getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Category findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Category findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<Article> selectAllArticlesByCategory(Long idCategory) {
		return dao.selectAllArticlesByCategory(idCategory);
	}

}
