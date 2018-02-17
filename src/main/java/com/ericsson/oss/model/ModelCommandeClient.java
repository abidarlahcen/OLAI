package com.ericsson.oss.model;

import java.util.Collection;
import java.util.Map;

import com.ericsson.oss.entites.Article;
import com.ericsson.oss.entites.Client;
import com.ericsson.oss.entites.CommandeClient;
import com.ericsson.oss.entites.LigneCommandeClient;

public interface ModelCommandeClient {

	void creerCommande();
	
	void modifierCommande(Client client);
	
	LigneCommandeClient ajouterLigneCommande(Article article);
	
	LigneCommandeClient supprimerLigneCommande(Article article);
	
	LigneCommandeClient modifierQuantite(Article article, double qte);
	
	String generateCodeCommande();
	
	CommandeClient getCommande();
	
	Map<Long, LigneCommandeClient> getLigneCde();
	
	Collection<LigneCommandeClient> getLignesCommandeClient(CommandeClient commande);
	
	void init();
}
