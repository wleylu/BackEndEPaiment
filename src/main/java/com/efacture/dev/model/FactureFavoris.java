package com.efacture.dev.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class FactureFavoris {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long typeFacture;
	private String reference;
	private String nomComplet;
	private String idClient;
	private boolean statut=true;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateCreate = new Date(System.currentTimeMillis());
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateUpdate;
	@Transient
	private boolean action;
	@Transient
	private Utilisateur utilisateur;
	@Transient
	private Vfacturier vfacturier;
	public FactureFavoris() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FactureFavoris(long id, long typeFacture, String reference, String nomComplet, String idClient,
			boolean statut, Date dateCreate, Date dateUpdate, boolean action, Utilisateur utilisateur,Vfacturier vfacturier) {
		super();
		this.id = id;
		this.typeFacture = typeFacture;
		this.reference = reference;
		this.nomComplet = nomComplet;
		this.idClient = idClient;
		this.statut = statut;
		this.dateCreate = dateCreate;
		this.dateUpdate = dateUpdate;
		this.action = action;
		this.utilisateur = utilisateur;
		this.vfacturier=vfacturier;
	}
	

	public FactureFavoris(long typeFacture, String reference, String nomComplet, Date dateUpdate) {
		super();
		this.typeFacture = typeFacture;
		this.reference = reference;
		this.nomComplet = nomComplet;
		this.dateUpdate = dateUpdate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTypeFacture() {
		return typeFacture;
	}
	public void setTypeFacture(long typeFacture) {
		this.typeFacture = typeFacture;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	public boolean getAction() {
		return action;
	}
	public void setAction(boolean action) {
		this.action = action;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Vfacturier getVfacturier() {
		return vfacturier;
	}

	public void setVfacturier(Vfacturier vfacturier) {
		this.vfacturier = vfacturier;
	}
}
