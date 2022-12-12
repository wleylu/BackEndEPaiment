package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.CompteMarchand;

public interface ServiceCptMarchand {
	public CompteMarchand rechercheCptCmByLogin(String login);
	public CompteMarchand rechercheNumCptCm(String num_cpt_cm);
	public CompteMarchand rechercheCptCmByLoginAndNumCptCm(String login,String num_cpt_cm);
	public CompteMarchand enregistrerCompteMarchand(CompteMarchand cptMarchand);
	public List<CompteMarchand> listeCptMarchand();
	public CompteMarchand modifierCptMarchand(CompteMarchand cptMarchand);
	public Long  supprimer(Long id);
}
