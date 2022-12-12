package com.efacture.dev.service;

import java.util.Date;

//import com.efacture.dev.model.CptMarchand;
import com.efacture.dev.model.Paiement;

public interface ServicePaie {
	public Paiement effectuerPaie(String numCpt,long montantFacture,
			String intituleFacturier,long frais,long timbre,String reference, String identifiant, long montantPaye, Date datePaiement, String typePaye, String codeReponse);
	public Paiement findByNumCpt(String numCpt);
	public Paiement retourPayement(String numCpt);
	
}
