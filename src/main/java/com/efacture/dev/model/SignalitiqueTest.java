package com.efacture.dev.model; 
import java.io.Serializable;

 
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

 
import javax.persistence.FetchType;


import javax.persistence.Id;

//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class SignalitiqueTest implements Serializable {
@Id
private String client;
private String sexe;
private String nomPrenom;
private String nom;
private String prenom;
private Date dateNais;
private int statut=0;
private String typeCpt;
private String numCpt;
private String numCptContribuable;
private String regCrc;
private int optionCm;
private String raisonSocial;
private String agec;
private String tel;
private String autreContact;
private String pieceId;
private Date dateExpir;
private Date dateDelivr;
private String email;
private String login;

private String adCm;
private Date dateModification;
private String loginModification;
private Date dateDesactivation;
private String loginDesactivation;
@Temporal(TemporalType.DATE)
private Date dateCreation = new Date(System.currentTimeMillis());
 
@OneToMany(mappedBy = "compteMarchand",fetch = FetchType.LAZY) 
private Collection<Comptes> comptes;

public SignalitiqueTest(String client, String nom, String prenom) {
	super();
	this.client = client;
	this.nom = nom;
	this.prenom = prenom;
}


public SignalitiqueTest() {

 
super();

 
}






public SignalitiqueTest(String client) {
	super();
	this.client = client;
}

@JsonIgnore
public SignalitiqueTest(List<Comptes> comptes) {
	super();
	this.comptes = comptes;
}



public SignalitiqueTest(String nom, String email) {
	super();
	this.nom = nom;
	this.email = email;
}


public SignalitiqueTest(String client, String sexe, String nomPrenom, String nom, String prenom, Date dateNais,
		int statut, String typeCpt, String numCpt, String numCptContribuable, String regCrc, int optionCm,
		String raisonSocial, String agec, String tel, String autreContact, String pieceId, Date dateExpir,
		Date dateDelivr, String email, String login, String adCm, Date dateModification, String loginModification,
		Date dateDesactivation, String loginDesactivation, Collection<Comptes> comptes) {
	super();
	this.client = client;
	this.sexe = sexe;
	this.nomPrenom = nomPrenom;
	this.nom = nom;
	this.prenom = prenom;
	this.dateNais = dateNais;
	this.statut = statut;
	this.typeCpt = typeCpt;
	this.numCpt = numCpt;
	this.numCptContribuable = numCptContribuable;
	this.regCrc = regCrc;
	this.optionCm = optionCm;
	this.raisonSocial = raisonSocial;
	this.agec = agec;
	this.tel = tel;
	this.autreContact = autreContact;
	this.pieceId = pieceId;
	this.dateExpir = dateExpir;
	this.dateDelivr = dateDelivr;
	this.email = email;
	this.login = login;
	this.adCm = adCm;
	this.dateModification = dateModification;
	this.loginModification = loginModification;
	this.dateDesactivation = dateDesactivation;
	this.loginDesactivation = loginDesactivation;
	this.comptes = comptes;
	
}


public SignalitiqueTest(String client, String sexe, String nomPrenom, String nom, String prenom, Date dateNais,
		int statut, String typeCpt, String numCpt, String numCptContribuable, String regCrc, int optionCm,
		String raisonSocial, String agec, String tel, String autreContact, String pieceId, Date dateExpir,
		Date dateDelivr, String email, String login, String adCm, Date dateModification, String loginModification,
		Date dateDesactivation, String loginDesactivation, Date dateCreation, List<Comptes> comptes) {
	super();
	this.client = client;
	this.sexe = sexe;
	this.nomPrenom = nomPrenom;
	this.nom = nom;
	this.prenom = prenom;
	this.dateNais = dateNais;
	this.statut = statut;
	this.typeCpt = typeCpt;
	this.numCpt = numCpt;
	this.numCptContribuable = numCptContribuable;
	this.regCrc = regCrc;
	this.optionCm = optionCm;
	this.raisonSocial = raisonSocial;
	this.agec = agec;
	this.tel = tel;
	this.autreContact = autreContact;
	this.pieceId = pieceId;
	this.dateExpir = dateExpir;
	this.dateDelivr = dateDelivr;
	this.email = email;
	this.login = login;
	this.adCm = adCm;
	this.dateModification = dateModification;
	this.loginModification = loginModification;
	this.dateDesactivation = dateDesactivation;
	this.loginDesactivation = loginDesactivation;
	this.dateCreation = dateCreation;
	this.comptes = comptes;
}

public String getClient() {
	return client;
}


public void setClient(String client) {
	this.client = client;
}


public String getSexe() {
	return sexe;
}


public void setSexe(String sexe) {
	this.sexe = sexe;
}


public String getNomPrenom() {
	return nomPrenom;
}


public void setNomPrenom(String nomPrenom) {
	this.nomPrenom = nomPrenom;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public String getPrenom() {
	return prenom;
}


public void setPrenom(String prenom) {
	this.prenom = prenom;
}


public Date getDateNais() {
	return dateNais;
}


public void setDateNais(Date dateNais) {
	this.dateNais = dateNais;
}


public int getStatut() {
	return statut;
}


public void setStatut(int statut) {
	this.statut = statut;
}


public String getTypeCpt() {
	return typeCpt;
}


public void setTypeCpt(String typeCpt) {
	this.typeCpt = typeCpt;
}


public String getNumCpt() {
	return numCpt;
}


public void setNumCpt(String numCpt) {
	this.numCpt = numCpt;
}


public String getNumCptContribuable() {
	return numCptContribuable;
}


public void setNumCptContribuable(String numCptContribuable) {
	this.numCptContribuable = numCptContribuable;
}


public String getRegCrc() {
	return regCrc;
}


public void setRegCrc(String regCrc) {
	this.regCrc = regCrc;
}


public int getOptionCm() {
	return optionCm;
}


public void setOptionCm(int optionCm) {
	this.optionCm = optionCm;
}


public String getRaisonSocial() {
	return raisonSocial;
}


public void setRaisonSocial(String raisonSocial) {
	this.raisonSocial = raisonSocial;
}


public String getAgec() {
	return agec;
}


public void setAgec(String agec) {
	this.agec = agec;
}


public String getTel() {
	return tel;
}


public void setTel(String tel) {
	this.tel = tel;
}


public String getAutreContact() {
	return autreContact;
}


public void setAutreContact(String autreContact) {
	this.autreContact = autreContact;
}


public String getPieceId() {
	return pieceId;
}


public void setPieceId(String pieceId) {
	this.pieceId = pieceId;
}


public Date getDateExpir() {
	return dateExpir;
}


public void setDateExpir(Date dateExpir) {
	this.dateExpir = dateExpir;
}


public Date getDateDelivr() {
	return dateDelivr;
}


public void setDateDelivr(Date dateDelivr) {
	this.dateDelivr = dateDelivr;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getLogin() {
	return login;
}


public void setLogin(String login) {
	this.login = login;
}


public String getAdCm() {
	return adCm;
}


public void setAdCm(String adCm) {
	this.adCm = adCm;
}


public Date getDateModification() {
	return dateModification;
}


public void setDateModification(Date dateModification) {
	this.dateModification = dateModification;
}


public String getLoginModification() {
	return loginModification;
}


public void setLoginModification(String loginModification) {
	this.loginModification = loginModification;
}


public Date getDateDesactivation() {
	return dateDesactivation;
}


public void setDateDesactivation(Date dateDesactivation) {
	this.dateDesactivation = dateDesactivation;
}


public String getLoginDesactivation() {
	return loginDesactivation;
}


public void setLoginDesactivation(String loginDesactivation) {
	this.loginDesactivation = loginDesactivation;
}


public Date getDateCreation() {
	return dateCreation;
}


public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}








public Collection<Comptes> getComptes() {
	return comptes;
}


public void setComptes(List<Comptes> comptes) {
	this.comptes = comptes;
}


@Override
public String toString() {
	return "CompteMarchand [client=" + client + ", sexe=" + sexe + ", nomPrenom=" + nomPrenom + ", nom="
			+ nom + ", prenom=" + prenom + ", dateNais=" + dateNais + ", statut=" + statut + ", typeCpt=" + typeCpt
			+ ", numCpt=" + numCpt + ", numCptContribuable=" + numCptContribuable + ", regCrc=" + regCrc + ", optionCm="
			+ optionCm + ", raisonSocial=" + raisonSocial + ", agec=" + agec + ", tel=" + tel + ", autreContact="
			+ autreContact + ", pieceId=" + pieceId + ", dateExpir=" + dateExpir + ", dateDelivr=" + dateDelivr
			+ ", email=" + email + ", login=" + login + ", adCm=" + adCm
			+ ", dateModification=" + dateModification + ", loginModification=" + loginModification
			+ ", dateDesactivation=" + dateDesactivation + ", loginDesactivation=" + loginDesactivation
			+ ", dateCreation=" + dateCreation + ", comptes=" + comptes + "]";
}




}