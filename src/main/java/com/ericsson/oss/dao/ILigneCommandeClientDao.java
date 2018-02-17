package com.ericsson.oss.dao;

import java.util.List;

import com.ericsson.oss.entites.LigneCommandeClient;

public interface ILigneCommandeClientDao extends IGenericDao<LigneCommandeClient> {
	
	public List<LigneCommandeClient> getByIdCommande(Long idCommandeClient);

}
