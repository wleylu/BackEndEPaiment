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
public class Vfacturier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private String facturier;
	private String loginAdd;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateAdd = new Date(System.currentTimeMillis());
	private String loginMaj;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateMaj = new Date(System.currentTimeMillis());
	
	
	public Vfacturier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFacturier() {
		return facturier;
	}
	public void setFacturier(String facturier) {
		this.facturier = facturier;
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


	public Vfacturier(long id, String facturier) {
		super();
		this.id = id;
		this.facturier = facturier;
	}


	@Override
	public String toString() {
		return "Vfacturier [id=" + id + ", facturier=" + facturier + ", loginAdd=" + loginAdd + ", dateAdd=" + dateAdd
				+ ", loginMaj=" + loginMaj + ", dateMaj=" + dateMaj + "]";
	}
	
	
	
}

