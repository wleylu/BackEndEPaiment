package com.efacture.dev.service;

 

import java.util.Date;
import java.util.List;

import com.efacture.dev.DTO.CompteMarchandDTO;
//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.MessageStatut;
import com.efacture.dev.model.Transaction;


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
	CompteMarchandDTO getBenificiaire(String refTransaction);
	MessageStatut generateCodeConfirmation(String refTransaction);
	List<Transaction> getLisTransactions(String loginAdd);
	List<CompteMarchandDTO> listePaiement(String loginAdd);
	List<CompteMarchandDTO> listeTransaction(String loginAdd,String refTran,String codeTran,String dateDebut,String DateFin);

}