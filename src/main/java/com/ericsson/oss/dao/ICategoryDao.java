package com.ericsson.oss.dao;

import java.util.List;

import com.ericsson.oss.entites.Article;
import com.ericsson.oss.entites.Category;

public interface ICategoryDao extends IGenericDao<Category> {
	
	public List<Article> selectAllArticlesByCategory(Long idCategory);

}
