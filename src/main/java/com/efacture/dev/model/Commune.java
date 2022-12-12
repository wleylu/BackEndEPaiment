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
public class Commune {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String idCe;
	private String intCe;
	private String loginAdd;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateAdd = new Date(System.currentTimeMillis());
	private String loginMaj;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateMaj = new Date(System.currentTimeMillis());
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
	public Commune() {
		super();
	}
	
	
	public Commune(long id, String idCe, String intCe, String loginAdd, Date dateAdd, String loginMaj, Date dateMaj) {
		super();
		this.id = id;
		this.idCe = idCe;
		this.intCe = intCe;
		this.loginAdd = loginAdd;
		this.dateAdd = dateAdd;
		this.loginMaj = loginMaj;
		this.dateMaj = dateMaj;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIdCe() {
		return idCe;
	}
	public void setIdCe(String idCe) {
		this.idCe = idCe;
	}
	public String getIntCe() {
		return intCe;
	}
	public void setIntCe(String intCe) {
		this.intCe = intCe;
	}
	@Override
	public String toString() {
		return "Commune [id=" + id + ", idCe=" + idCe + ", intCe=" + intCe + ", loginAdd=" + loginAdd + ", dateAdd="
				+ dateAdd + ", loginMaj=" + loginMaj + ", dateMaj=" + dateMaj + "]";
	}
	
	
}
