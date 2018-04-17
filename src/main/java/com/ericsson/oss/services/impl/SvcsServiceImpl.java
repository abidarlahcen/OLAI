package com.ericsson.oss.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ericsson.oss.dao.ISvcsDao;
import com.ericsson.oss.entites.Svcs;
import com.ericsson.oss.services.ISvcsService;
@Transactional

public class SvcsServiceImpl implements ISvcsService {
	
		
		private ISvcsDao dao;
		
		public void setDao(ISvcsDao dao) {
			this.dao = dao;
		}

		@Override
		public Svcs save(Svcs entity) {
			return dao.save(entity);
		}

		@Override
		public Svcs update(Svcs entity) {
			return dao.update(entity);
		}

		@Override
		public List<Svcs> selectAll() {
			return dao.selectAll();
		}

		@Override
		public List<Svcs> selectAll(String sortField, String sort) {
			return dao.selectAll(sortField, sort);
		}

		@Override
		public Svcs getById(Long id) {
			return dao.getById(id);
		}

		@Override
		public void remove(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Svcs findOne(String paramName, Object paramValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Svcs findOne(String[] paramNames, Object[] paramValues) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int findCountBy(String paramName, String paramValue) {
			// TODO Auto-generated method stub
			return 0;
		}
}
