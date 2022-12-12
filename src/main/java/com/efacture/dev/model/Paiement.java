package com.efacture.dev.model;

import java.util.Date;

//import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Paiement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String numCpt;
	private long montantFacture;
	private String intituleFacturier;
	private String typePaye;
	private long frais;
	private long timbre;
	private String reference;
	private String codeReponse;
	private String identifiant;
	private long montantPaye;

	@Temporal(TemporalType.DATE)
	private Date datePaiement = new Date(System.currentTimeMillis());

	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Paiement(long id, String numCpt, long montantFacture, String intituleFacturier, String typePaye, long frais,
			long timbre, String reference, String codeReponse, String identifiant, long montantPaye, Date datePaiement) {
		super();
		this.id = id;
		this.numCpt = numCpt;
		this.montantFacture = montantFacture;
		this.intituleFacturier = intituleFacturier;
		this.typePaye = typePaye;
		this.frais = frais;
		this.timbre = timbre;
		this.reference = reference;
		this.codeReponse = codeReponse;
		this.identifiant = identifiant;
		this.montantPaye = montantPaye;
		this.datePaiement = datePaiement;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public long getMontantPaye() {
		return montantPaye;
	}

	public void setMontantPaye(long montantPaye) {
		this.montantPaye = montantPaye;
	}



	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public String getNumCpt() {
		return numCpt;
	}

	public void setNumCpt(String numCpt) {
		this.numCpt = numCpt;
	}

	public long getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(long montantFacture) {
		this.montantFacture = montantFacture;
	}

	public String getIntituleFacturier() {
		return intituleFacturier;
	}

	public void setIntituleFacturier(String intituleFacturier) {
		this.intituleFacturier = intituleFacturier;
	}

	public String getTypePaye() {
		return typePaye;
	}

	public void setTypePaye(String typePaye) {
		this.typePaye = typePaye;
	}

	public long getFrais() {
		return frais;
	}

	public void setFrais(long frais) {
		this.frais = frais;
	}

	public long getTimbre() {
		return timbre;
	}

	public void setTimbre(long timbre) {
		this.timbre = timbre;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCodeReponse() {
		return codeReponse;
	}

	public void setCodeReponse(String codeReponse) {
		this.codeReponse = codeReponse;
	}

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", numCpt=" + numCpt + ", montantFacture=" + montantFacture
				+ ", intituleFacturier=" + intituleFacturier + ", typePaye=" + typePaye + ", frais=" + frais
				+ ", timbre=" + timbre + ", reference=" + reference + ", codeReponse=" + codeReponse + ", identifiant="
				+ identifiant + ", montantPaye=" + montantPaye + ", datePaiement=" + datePaiement + "]";
	}

}
