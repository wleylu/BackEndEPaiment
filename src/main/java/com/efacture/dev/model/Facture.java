package com.efacture.dev.model;

import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String refFacture;
	@Temporal(TemporalType.DATE)
	private Date dtExpFacture =new Date(System.currentTimeMillis());
	private String intFacturier;
	private long Montant;
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(long id, String refFacture, Date dtExpFacture, String intFacturier, long montant) {
		super();
		this.id = id;
		this.refFacture = refFacture;
		this.dtExpFacture = dtExpFacture;
		this.intFacturier = intFacturier;
		Montant = montant;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRefFacture() {
		return refFacture;
	}
	public void setRefFacture(String refFacture) {
		this.refFacture = refFacture;
	}
	public Date getDtExpFacture() {
		return dtExpFacture;
	}
	public void setDtExpFacture(Date dtExpFacture) {
		this.dtExpFacture = dtExpFacture;
	}
	public String getIntFacturier() {
		return intFacturier;
	}
	public void setIntFacturier(String intFacturier) {
		this.intFacturier = intFacturier;
	}
	public long getMontant() {
		return Montant;
	}
	public void setMontant(long montant) {
		Montant = montant;
	}
	@Override
	public String toString() {
		return "Facture [id=" + id + ", refFacture=" + refFacture + ", dtExpFacture=" + dtExpFacture + ", intFacturier="
				+ intFacturier + ", Montant=" + Montant + "]";
	}
	
	
}
