package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.CompteMarchand;
//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.Comptes;

public interface ServiceCompte {
	public List<Comptes> cpt();

	public Comptes ajouterCompte(String code, Comptes cpt);

//public Comptes saveCompte( Comptes cpt);
	public Comptes getCompteById(String cptId);

	public List<Comptes> getByCompteMarchand(String code);

	public Comptes updateCpt(Comptes cpt);

//public List<Comptes> trouverListeCompte(Long c);
	List<Comptes> getByCompteMarchand(CompteMarchand code);
	
	public List<Comptes> CompteByStatut(String code);
}
