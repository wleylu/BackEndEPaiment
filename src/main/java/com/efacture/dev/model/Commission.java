package com.efacture.dev.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Commission {
	@Id
	@GeneratedValue
	private Long idCommission;
	private Long montantCommission;
	private int pourCommarch;
	private int pourCombank;
	private Long commissionFacturier;
	private Long commissionBanque;
	private String libelle;
	private String facturier;
	private String loginAdd;
	private int mntMax=0;
	private int mntTimbre=0;
	private String habilitation;
	private int mntMin=0;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateAdd = new Date(System.currentTimeMillis());
	private String loginMaj;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateMaj = new Date(System.currentTimeMillis());
	
	public Commission() {
		super();
	}
	
	public Commission(Long idCommission) {
		super();
		this.idCommission = idCommission;
	}
	
//	public Commission(Long montantCommission, int typeCommission, int pourCommarch, int pourCombank,
//			Long commissionFacturier, Long commissionBanque, String libelle, String facturier, String loginAdd,
//			Date dateAdd, String loginMaj, Date dateMaj
////			
//			) {
//		super();
//		this.montantCommission = montantCommission;
//		this.typeCommission = typeCommission;
//		this.pourCommarch = pourCommarch;
//		this.pourCombank = pourCombank;
//		this.commissionFacturier = commissionFacturier;
//		this.commissionBanque = commissionBanque;
//		this.libelle = libelle;
//		this.facturier = facturier;
//		this.loginAdd = loginAdd;
//		this.dateAdd = dateAdd;
//		this.loginMaj = loginMaj;
//		this.dateMaj = dateMaj;
//	}

	
	
//	public Commission(Long montantCommission, int typeCommission, int pourCommarch, int pourCombank,
//			Long commissionFacturier, Long commissionBanque, String libelle, String facturier, String loginAdd,
//			Date dateAdd, String loginMaj, Date dateMaj) {
//		super();
//		this.montantCommission = montantCommission;
//		this.typeCommission = typeCommission;
//		this.pourCommarch = pourCommarch;
//		this.pourCombank = pourCombank;
//		this.commissionFacturier = commissionFacturier;
//		this.commissionBanque = commissionBanque;
//		this.libelle = libelle;
//		this.facturier = facturier;
//		this.loginAdd = loginAdd;
//		this.dateAdd = dateAdd;
//		this.loginMaj = loginMaj;
//		this.dateMaj = dateMaj;
//	}
	
	

	

	public Long getIdCommission() {
		return idCommission;
	}
	



	public Commission(Long idCommission, Long montantCommission, int pourCommarch, int pourCombank,
		Long commissionFacturier, Long commissionBanque, String libelle, String facturier, String loginAdd, int mntMin,
		int mntMax, int mntTimbre, String habilitation, Date dateAdd, String loginMaj, Date dateMaj) {
	super();
	this.idCommission = idCommission;
	this.montantCommission = montantCommission;
	this.pourCommarch = pourCommarch;
	this.pourCombank = pourCombank;
	this.commissionFacturier = commissionFacturier;
	this.commissionBanque = commissionBanque;
	this.libelle = libelle;
	this.facturier = facturier;
	this.loginAdd = loginAdd;
	this.setMntMin(mntMin);
	this.mntMax = mntMax;
	this.mntTimbre = mntTimbre;
	this.habilitation = habilitation;
	this.dateAdd = dateAdd;
	this.loginMaj = loginMaj;
	this.dateMaj = dateMaj;
}

	public int getMntMax() {
		return mntMax;
	}

	public void setMntMax(int mntMax) {
		this.mntMax = mntMax;
	}

	public int getMntTimbre() {
		return mntTimbre;
	}

	public void setMntTimbre(int mntTimbre) {
		this.mntTimbre = mntTimbre;
	}

	public void setIdCommission(Long idCommission) {
		this.idCommission = idCommission;
	}
	public Long getMontantCommission() {
		return montantCommission;
	}
	public void setMontantCommission(Long montantCommission) {
		this.montantCommission = montantCommission;
	}
	
	public int getPourCommarch() {
		return pourCommarch;
	}
	public void setPourCommarch(int pourCommarch) {
		this.pourCommarch = pourCommarch;
	}
	public int getPourCombank() {
		return pourCombank;
	}
	public void setPourCombank(int pourCombank) {
		this.pourCombank = pourCombank;
	}
	public Long getCommissionFacturier() {
		return commissionFacturier;
	}
	public void setCommissionFacturier(Long commissionFacturier) {
		this.commissionFacturier = commissionFacturier;
	}
	public Long getCommissionBanque() {
		return commissionBanque;
	}
	public void setCommissionBanque(Long commissionBanque) {
		this.commissionBanque = commissionBanque;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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



	public String getHabilitation() {
		return habilitation;
	}

	public void setHabilitation(String habilitation) {
		this.habilitation = habilitation;
	}

	public int getMntMin() {
		return mntMin;
	}

	public void setMntMin(int mntMin) {
		this.mntMin = mntMin;
	}
	
	
}
