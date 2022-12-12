package com.efacture.dev.model;

import java.util.Date;

//import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserAuditConnect {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String role;
	private Date dateConnexion;
	private String statut;
	public UserAuditConnect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAuditConnect(Long id, String login, String role, Date dateConnexion, String statut) {
		super();
		this.id = id;
		this.login = login;
		this.role = role;
		this.dateConnexion = dateConnexion;
		this.statut = statut;
	}
	public long getId() {
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
	public Date getDateConnexion() {
		return dateConnexion;
	}
	public void setDateConnexion(Date dateConnexion) {
		this.dateConnexion = dateConnexion;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "UserAuditConnect [id=" + id + ", login=" + login + ", role=" + role + ", dateConnexion="
				+ dateConnexion + ", statut=" + statut + "]";
	}
	
	
}
