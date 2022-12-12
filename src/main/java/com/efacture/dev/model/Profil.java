package com.efacture.dev.model;

import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Profil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String typeProfil;
	@Temporal(TemporalType.DATE)
	private Date dcProfil = new Date(System.currentTimeMillis());

	private String loginAdd;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateAdd = new Date(System.currentTimeMillis());
	private String loginMaj;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateMaj = new Date(System.currentTimeMillis());

	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profil(long id, String typeProfil, Date dcProfil) {
		super();
		this.id = id;
		this.typeProfil = typeProfil;
		this.dcProfil = dcProfil;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeProfil() {
		return typeProfil;
	}

	public void setTypeProfil(String typeProfil) {
		this.typeProfil = typeProfil;
	}

	public Date getDcProfil() {
		return dcProfil;
	}

	public void setDcProfil(Date dcProfil) {
		this.dcProfil = dcProfil;
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

	@Override
	public String toString() {
		return "Profil [id=" + id + ", typeProfil=" + typeProfil + ", dcProfil=" + dcProfil + ", loginAdd=" + loginAdd
				+ ", dateAdd=" + dateAdd + ", loginMaj=" + loginMaj + ", dateMaj=" + dateMaj + "]";
	}

}
