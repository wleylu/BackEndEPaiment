package com.efacture.dev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParaCommission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long mntFrais;
	private long mntFraisMarchand;
	private long mntTimbre;
	private long mntMarchand;
	private String codOper;
	private String codeOperateur;
	private String typeCanal;

	public ParaCommission(long id, long mntFrais, long mntFraisMarchand, long mntTimbre, long mntMarchand, String codOper,
			String codeOperateur, String typeCanal) {
		super();
		this.id = id;
		this.mntFrais = mntFrais;
		this.mntFraisMarchand = mntFraisMarchand;
		this.mntTimbre = mntTimbre;
		this.mntMarchand = mntMarchand;
		this.codOper = codOper;
		this.codeOperateur = codeOperateur;
		this.typeCanal = typeCanal;
	}

	public ParaCommission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodeOperateur() {
		return codeOperateur;
	}

	public void setCodeOperateur(String codeOperateur) {
		this.codeOperateur = codeOperateur;
	}

	public long getMntFrais() {
		return mntFrais;
	}

	public void setMntFrais(long mntFrais) {
		this.mntFrais = mntFrais;
	}

	public long getMntFraisMarchand() {
		return mntFraisMarchand;
	}

	public void setMntFraisMarchand(long mntFraisMarchand) {
		this.mntFraisMarchand = mntFraisMarchand;
	}

	public long getMntTimbre() {
		return mntTimbre;
	}

	public void setMntTimbre(long mntTimbre) {
		this.mntTimbre = mntTimbre;
	}

	public String getCodOper() {
		return codOper;
	}

	public void setCodOper(String codOper) {
		this.codOper = codOper;
	}

	public long getMntMarchand() {
		return mntMarchand;
	}

	public void setMntMarchand(long mntMarchand) {
		this.mntMarchand = mntMarchand;
	}


	public String getTypeCanal() {
		return typeCanal;
	}

	public void setTypeCanal(String typeCanal) {
		this.typeCanal = typeCanal;
	}

	@Override
	public String toString() {
		return "Commission [id=" + id + ", mntFrais=" + mntFrais + ", mntFraisMarchand=" + mntFraisMarchand
				+ ", mntTimbre=" + mntTimbre + ", mntMarchand=" + mntMarchand + ", codOper=" + codOper
				+ ", codeOperateur=" + codeOperateur + ", typeCanal=" + typeCanal + "]";
	}

}
