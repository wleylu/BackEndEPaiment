package com.efacture.dev.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mail")

public class Mail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String expediteur;
	private String destinataire;
	private String objet;
	@Column(length=300)
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	@Override
	public String toString() {
		return "Mail [id=" + id + ", expediteur=" + expediteur + ", destinataire=" + destinataire + ", objet=" + objet
				+ ", message=" + message + "]";
	}


	public Mail(String expediteur, String destinataire, String objet, String message) {
		super();
		this.expediteur = expediteur;
		this.destinataire = destinataire;
		this.objet = objet;
		this.message = message;
	}

	public Mail() {
		super();
// TODO Auto-generated constructor stub
	}

}