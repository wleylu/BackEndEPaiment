package com.efacture.dev.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class Comptes implements Serializable {
	@Id
	private String compte;
	private String agence;
	private String ncg;
	private String libNcg;
	private String coddci;
	private String expl;
	private int statut = 1;

	@ManyToOne
	@JoinColumn(name = "CODE")
//@OnDelete(action = OnDeleteAction.CASCADE)
	private CompteMarchand compteMarchand;
	
	

	public Comptes() {
		super();
// TODO Auto-generated constructor stub
	}

	public Comptes(String compte, String agence, String ncg, String libNcg, String coddci, String expl, int statut,
			CompteMarchand compteMarchand) {
		super();
		this.compte = compte;
		this.agence = agence;
		this.ncg = ncg;
		this.libNcg = libNcg;
		this.coddci = coddci;
		this.expl = expl;
		this.statut = statut;
		this.compteMarchand = compteMarchand;
	}

	public Comptes(String compte, String agence, String ncg, String libNcg, String coddci, String expl,
			int statut) {
		super();
		this.compte = compte;
		this.agence = agence;
		this.ncg = ncg;
		this.libNcg = libNcg;
		this.coddci = coddci;
		this.expl = expl;
		this.statut = statut;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public Comptes(CompteMarchand compteMarchand) {
		super();
		this.compteMarchand = compteMarchand;
	}

	public String getCompte() {
		return compte;
	}

	public void setCompte(String compte) {
		this.compte = compte;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getNcg() {
		return ncg;
	}

	public void setNcg(String ncg) {
		this.ncg = ncg;
	}

	public String getLibNcg() {
		return libNcg;
	}

	public void setLibNcg(String libNcg) {
		this.libNcg = libNcg;
	}

	public String getCoddci() {
		return coddci;
	}

	public void setCoddci(String coddci) {
		this.coddci = coddci;
	}

	public String getExpl() {
		return expl;
	}

	public void setExpl(String expl) {
		this.expl = expl;
	}

//@JsonIgnore
	public CompteMarchand getCompteMarchand() {
		return compteMarchand;
	}

	@JsonIgnore
	public void setCompteMarchand(CompteMarchand compteMarchand) {
		this.compteMarchand = compteMarchand;
	}

	
	
	
	

}