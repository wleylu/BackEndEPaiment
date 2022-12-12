package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.ReglementSodeci;

public interface RgSodeciService {
	public  ReglementSodeci addReglement(ReglementSodeci reglementSodeci);
	public ReglementSodeci updateReglement(ReglementSodeci reglementSodeci);
	public List<ReglementSodeci> listeReglement();
	public List<ReglementSodeci> getReglementByStatut(String statut);
}
