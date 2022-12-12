package com.efacture.dev.service;

 

import java.util.List;

//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.MessageStatut;


public interface ServiceCm {
    
	public CompteMarchand ajouterCm(CompteMarchand c);
    public List<CompteMarchand> listMarchands();
       public CompteMarchand getMarchand(String client);
    public CompteMarchand getByEmail(String email);
    public String getByMarchandByMail(String email);
    public List<CompteMarchand> rechercheByLogin(String login);
    public List<CompteMarchand> rechercheByNomAndLogin(String login,String nom);
    public CompteMarchand modifierCm(CompteMarchand cptMarchand);
	List<CompteMarchand> rechercheByNom(String nom);
	MessageStatut addBeneficiaire(CompteMarchand marchand);
	MessageStatut modifierMarchand(CompteMarchand cptMarchand);
	List<CompteMarchand> listeBenefParLogin(String refTransaction, String nom, String login);

}