package com.efacture.dev.service;

import java.util.Date;
import java.util.List;

//import com.efacture.dev.model.Facturier;
import com.efacture.dev.model.Reclamation;

public interface ServiceReclamation {
	Reclamation postReclamation(Reclamation reclamation);
	public List <Reclamation> getReclamByLogin(String login);
	public List<Reclamation> listeReclamantion();
    public List<Reclamation> rechercheReclamation(Date firstDate,Date lastDate,String login,String nom,String facturier,String reference);
    public List<Reclamation> getReclamation(String login,String nom,String facturier,String reference);
}
