package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.CustomResponse;
import com.efacture.dev.model.FactureFavoris;

public interface IServiceFactureFavoris {
	/*************Cette methode permet au client******************* 
	 ************d'ajouter,modifier et desactiver une facture en favoris******************
	 ************************************************************/
	public CustomResponse saveFactureFavoris(FactureFavoris factureFavoris);
	
	/*************Cette methode permet au client******************* 
	 ************de visualiser la liste des facture favoris actif******************
	 ************************************************************/
	public List<FactureFavoris> listFactureFavoris(String idClient, boolean statut);
}
