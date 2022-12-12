package com.efacture.dev.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Plafond {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPlafond;
	private long nombreFacture;
	private long montantMax;
	private int typePlafond;

	private String loginAdd;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateAdd = new Date(System.currentTimeMillis());
	private String loginMaj;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateMaj = new Date(System.currentTimeMillis());

	public Plafond() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plafond(long nombreFacture, long montantMax, int typePlafond,String loginAdd, Date dateAdd, String loginMaj, Date dateMaj) {
		super();
		this.nombreFacture = nombreFacture;
		this.montantMax = montantMax;
		this.typePlafond = typePlafond;
		this.loginAdd = loginAdd;
		this.dateAdd = dateAdd;
		this.loginMaj = loginMaj;
		this.dateMaj = dateMaj;
	}
	
	
	public long getIdPlafond() {
		return idPlafond;
	}

	public void setIdPlafond(long idPlafond) {
		this.idPlafond = idPlafond;
	}

	public long getNombreFacture() {
		return nombreFacture;
	}

	public void setNombreFacture(long nombreFacture) {
		this.nombreFacture = nombreFacture;
	}

	public long getMontantMax() {
		return montantMax;
	}

	public void setMontantMax(long montantMax) {
		this.montantMax = montantMax;
	}

	public int getTypePlafond() {
		return typePlafond;
	}

	public void setTypePlafond(int typePlafond) {
		this.typePlafond = typePlafond;
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
