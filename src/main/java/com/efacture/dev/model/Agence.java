package com.efacture.dev.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Agence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20)
	private String codAgence;
	@Column(length = 150)
	private String libelle;
	@OneToMany(mappedBy = "agence",fetch = FetchType.LAZY)
	@JsonIgnore
	private Collection<Utilisateur> utilisateurs;
	
	@OneToMany(mappedBy = "agence",fetch = FetchType.LAZY)
	@JsonIgnore
	private Collection<CompteMarchand> compteMarchand;
	
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Agence(Long id) {
		super();
		this.id = id;
	}



	public Collection<CompteMarchand> getCompteMarchand() {
		return compteMarchand;
	}



	public void setCompteMarchand(Collection<CompteMarchand> compteMarchand) {
		this.compteMarchand = compteMarchand;
	}



	public Agence(String codAgence, String libelle) {
		super();
		this.codAgence = codAgence;
		this.libelle = libelle;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodAgence() {
		return codAgence;
	}
	public void setCodAgence(String codAgence) {
		this.codAgence = codAgence;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	
}
