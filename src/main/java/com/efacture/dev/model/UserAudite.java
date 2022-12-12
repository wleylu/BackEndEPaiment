package com.efacture.dev.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Entity
public class UserAudite implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String login;
	private String nom;
	private String prenom;
	private String role;
	private String statut;
	private String adresseIp;
	private String host;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date=new Date();
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private Date heureAudit = new Date(System.currentTimeMillis());

	public UserAudite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserAudite(Long id, String login, String nom, String prenom, String role, String statut,String adresseIp,String host) {
		super();
		this.id = id;
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.statut = statut;
		this.adresseIp = adresseIp;
		this.host = host;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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

	public Date getHeureAudit() {
		return heureAudit;
	}

	public void setHeureAudit(Date heureAudit) {
		this.heureAudit = heureAudit;
	}

	public String getAdresseIp() {
		return adresseIp;
	}

	public void setgetAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}
		

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}

	@Override
	public String toString() {
		return "UserAudite [id=" + id + ", login=" + login + ", role=" + role + ", Statut=" + statut + ", date=" + date + "]";
	}
	
}
