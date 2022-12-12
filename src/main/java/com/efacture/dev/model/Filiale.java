package com.efacture.dev.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Filiale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 6)
	private String codeFiliale;
	@Column(length = 150)
	private String libelle;
	@OneToMany(mappedBy = "filiale")
	@JsonIgnore
	private Collection<Utilisateur> utilisateurs;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeFiliale() {
		return codeFiliale;
	}
	public void setCodeFiliale(String codeFiliale) {
		this.codeFiliale = codeFiliale;
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
	public Filiale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filiale(String codeFiliale, String libelle) {
		super();
		this.codeFiliale = codeFiliale;
		this.libelle = libelle;
	}
	public Filiale(Long id) {
		super();
		this.id = id;
	}

	
	
	
	
}
