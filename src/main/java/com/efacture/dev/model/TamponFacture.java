package com.efacture.dev.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class TamponFacture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateRegle = new Date(System.currentTimeMillis());
	private String reference;
	private String referenceExt;
	private long montantDebite;
	private String typeRegle;
	private String facturier;
	private String identifiant;
	private String numeroFacture;
	// @JsonFormat(pattern="dd-mm-yyyy")
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private Date heure = new Date(System.currentTimeMillis());
	private String dtExpFacture;
	private String statut;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateAdd = new Date(System.currentTimeMillis());
	public TamponFacture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TamponFacture(Date dateRegle, String reference, String referenceExt, long montantDebite,
			String typeRegle, String facturier, String identifiant, String numeroFacture, Date heure,
			String dtExpFacture, String statut, Date dateAdd) {
		super();
		this.dateRegle = dateRegle;
		this.reference = reference;
		this.referenceExt = referenceExt;
		this.montantDebite = montantDebite;
		this.typeRegle = typeRegle;
		this.facturier = facturier;
		this.identifiant = identifiant;
		this.numeroFacture = numeroFacture;
		this.heure = heure;
		this.dtExpFacture = dtExpFacture;
		this.statut = statut;
		this.dateAdd = dateAdd;
	}
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
	public String getReferenceExt() {
		return referenceExt;
	}
	public void setReferenceExt(String referenceExt) {
		this.referenceExt = referenceExt;
	}
	public long getMontantDebite() {
		return montantDebite;
	}
	public void setMontantDebite(long montantDebite) {
		this.montantDebite = montantDebite;
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
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getNumeroFacture() {
		return numeroFacture;
	}
	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}
	public Date getHeure() {
		return heure;
	}
	public void setHeure(Date heure) {
		this.heure = heure;
	}
	public String getDtExpFacture() {
		return dtExpFacture;
	}
	public void setDtExpFacture(String dtExpFacture) {
		this.dtExpFacture = dtExpFacture;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDateAdd() {
		return dateAdd;
	}
	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}
	
	
	
}
