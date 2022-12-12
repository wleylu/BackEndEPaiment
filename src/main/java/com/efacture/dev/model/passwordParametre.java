package com.efacture.dev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class passwordParametre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nbJours;
	private String lienPremClient;
	private String lienPremAdmin;
	private String mailEfacture;
	
	
	
	public passwordParametre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbJours() {
		return nbJours;
	}
	public void setNbJours(int nbJours) {
		this.nbJours = nbJours;
	}
	
	
	public String getLienPremClient() {
		return lienPremClient;
	}
	public void setLienPremClient(String lienPremClient) {
		this.lienPremClient = lienPremClient;
	}
	public String getLienPremAdmin() {
		return lienPremAdmin;
	}
	public void setLienPremAdmin(String lienPremAdmin) {
		this.lienPremAdmin = lienPremAdmin;
	}
	
	
	public String getMailEfacture() {
		return mailEfacture;
	}
	public void setMailEfacture(String mailEfacture) {
		this.mailEfacture = mailEfacture;
	}
	
	public passwordParametre(int id, int nbJours, String lienPremClient, String lienPremAdmin, String mailEfacture) {
		super();
		this.id = id;
		this.nbJours = nbJours;
		this.lienPremClient = lienPremClient;
		this.lienPremAdmin = lienPremAdmin;
		this.mailEfacture = mailEfacture;
	}
	@Override
	public String toString() {
		return "passwordParametre [id=" + id + ", nbJours=" + nbJours + ", lienPremClient=" + lienPremClient
				+ ", lienPremAdmin=" + lienPremAdmin + ", mailEfacture=" + mailEfacture + "]";
	}

}
