package com.efacture.dev.model;

import java.util.Date;

//import java.util.Date;

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
public class Reclamation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String login;
	private String nom;
	private String prenom;
	private String telephone;
	private String facturier;
	private String numCpt;
	private String reference;
	private String motif;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateReclamation = new Date(System.currentTimeMillis());
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private Date heureReclamation = new Date(System.currentTimeMillis());
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFacturier() {
		return facturier;
	}

	public void setFacturier(String facturier) {
		this.facturier = facturier;
	}

	public String getNumCpt() {
		return numCpt;
	}

	public void setNumCpt(String numCpt) {
		this.numCpt = numCpt;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Reclamation(long id, String login, String nom, String prenom, String telephone, String facturier, String numCpt,
			String reference, String motif) {
		super();
		this.id = id;
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.facturier = facturier;
		this.numCpt = numCpt;
		this.reference = reference;
		this.motif = motif;
	}

	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", login =" + login + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone
				+ ", facturier=" + facturier + ", numCpt=" + numCpt + ", reference=" + reference + ", motif=" + motif
				+ "]";
	}

}
