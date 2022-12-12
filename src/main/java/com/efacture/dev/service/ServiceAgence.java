package com.efacture.dev.service;

import java.util.List;
import java.util.Optional;

import com.efacture.dev.model.Agence;


public interface ServiceAgence {
	public Agence addAgence(Agence agence);
	public List<Agence> agence();
	public Agence updateAgence(Agence agence);
	public Optional<Agence> recherche(Long id);
	public Agence rechercheByCodeAgence(String cod_agence);

}
