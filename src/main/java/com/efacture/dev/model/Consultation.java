package com.efacture.dev.model;

import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Consultation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateRegle = new Date(System.currentTimeMillis());
	private String reference;
	private String referenceFT;
	private String referenceExt;
	private long montantDebite;
	private String numCpt;
	private String typeRegle;
	private String facturier;
	private String login;
	private String identifiant;
	private String filiale;
	private String numeroFacture;
	// @JsonFormat(pattern="dd-mm-yyyy")
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private Date heure = new Date(System.currentTimeMillis());
	private String dtExpFacture;
	private String statut;
	private String loginAdd;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateAdd = new Date(System.currentTimeMillis());
	private String loginMaj;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateMaj = new Date(System.currentTimeMillis());

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateRegle() {
		return dateRegle;
	}

	public void setDateRegle(Date dateRegle) {
		this.dateRegle = dateRegle;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public long getMontantDebite() {
		return montantDebite;
	}

	public void setMontantDebite(long montantDebite) {
		this.montantDebite = montantDebite;
	}

	public String getNumCpt() {
		return numCpt;
	}
	
	

	public void setNumCpt(String numCpt) {
		this.numCpt = numCpt;
	}

	public String getTypeRegle() {
		return typeRegle;
	}

	public void setTypeRegle(String typeRegle) {
		this.typeRegle = typeRegle;
	}

	public String getFacturier() {
		return facturier;
	}

	public void setFacturier(String facturier) {
		this.facturier = facturier;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getFiliale() {
		return filiale;
	}

	public void setFiliale(String filiale) {
		this.filiale = filiale;
	}

	public String getDtExpFacture() {
		return dtExpFacture;
	}

	public void setDtExpFacture(String dtExpFacture) {
		this.dtExpFacture = dtExpFacture;
	}

	public String getReferenceFT() {
		return referenceFT;
	}

	public void setReferenceFT(String referenceFT) {
		this.referenceFT = referenceFT;
	}

	public String getReferenceExt() {
		return referenceExt;
	}

	public void setReferenceExt(String referenceExt) {
		this.referenceExt = referenceExt;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getHeure() {
		return heure;
	}

	public void setHeure(Date heure) {
		this.heure = heure;
	}

	
	
	public String getLoginAdd() {
		return loginAdd;
	}

	public void setLoginAdd(String loginAdd) {
		this.loginAdd = loginAdd;
	}

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	public String getLoginMaj() {
		return loginMaj;
	}

	public void setLoginMaj(String loginMaj) {
		this.loginMaj = loginMaj;
	}

	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public Consultation(long id, Date dateRegle, String reference, String referenceFT, long montantDebite,
			String numCpt, String typeRegle, String facturier, String login, String identifiant, String dtExpFacture,
			String statut, Date heure, String filiale,String numeroFacture, String referenceExt) {
		super();
		this.id = id;
		this.dateRegle = dateRegle;
		this.reference = reference;
		this.referenceFT = referenceFT;
		this.referenceExt = referenceExt;
		this.montantDebite = montantDebite;
		this.numCpt = numCpt;
		this.typeRegle = typeRegle;
		this.facturier = facturier;
		this.login = login;
		this.identifiant = identifiant;
		this.dtExpFacture = dtExpFacture;
		this.statut = statut;
		this.heure = heure;
		this.filiale = filiale;
		this.numeroFacture=numeroFacture;
	}

	@Override
	public String toString() {
		return "Consultation [id=" + id + ", dateRegle=" + dateRegle + ", reference=" + reference + ", referenceFT="
				+ referenceFT + ", referenceExt=" + referenceExt + ", montantDebite=" + montantDebite + ", numCpt="
				+ numCpt + ", typeRegle=" + typeRegle + ", facturier=" + facturier + ", login=" + login
				+ ", identifiant=" + identifiant + ", filiale=" + filiale + ", heure=" + heure + ", dtExpFacture="
				+ dtExpFacture + ", statut=" + statut + ", loginAdd=" + loginAdd + ", dateAdd=" + dateAdd
				+ ", loginMaj=" + loginMaj + ", dateMaj=" + dateMaj + "]";
	}

	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

}