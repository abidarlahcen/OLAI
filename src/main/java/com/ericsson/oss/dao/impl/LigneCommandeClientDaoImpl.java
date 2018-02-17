package com.ericsson.oss.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.ericsson.oss.dao.ILigneCommandeClientDao;
import com.ericsson.oss.entites.LigneCommandeClient;

public class LigneCommandeClientDaoImpl  extends GenericDaoImpl<LigneCommandeClient> implements ILigneCommandeClientDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommandeClient> getByIdCommande(Long idCommandeClient) {
		String queryString = "select lc from " + LigneCommandeClient.class.getSimpleName() + " lc where lc.commandeClient.idCommandeClient = :x";
		Query query = em.createQuery(queryString);
		query.setParameter("x", idCommandeClient);
		return query.getResultList();
	}

}
