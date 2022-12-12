package com.efacture.dev.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TypePaiement {
	@Id
	private int type;
	private String libelle;
	private String loginAdd;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateAdd = new Date(System.currentTimeMillis());
	private String loginMaj;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateMaj = new Date(System.currentTimeMillis());

	public TypePaiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypePaiement(int type, String libelle) {
		super();
		this.type = type;
		this.setLibelle(libelle);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TypePaiement [type=" + type + "]";
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLoginAdd() {
		return loginAdd;
	}

	public void setLoginAdd(String loginAdd) {
		this.loginAdd = loginAdd;
	}

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	public String getLoginMaj() {
		return loginMaj;
	}

	public void setLoginMaj(String loginMaj) {
		this.loginMaj = loginMaj;
	}

	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	
}
