package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.ReglementCie;

public interface RgCieService {
	public ReglementCie addReglement(ReglementCie reglementCie);

	public ReglementCie updateReglement(ReglementCie reglementCie);

	public List<ReglementCie> listeReglement();

	public List<ReglementCie> getReglementByStatut(String statut);
}
