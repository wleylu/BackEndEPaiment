package com.efacture.dev.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PaieTest {
	@Id
	private String client;
	private String facturier ;  //valeur cie=P05 et CIE=272
	private String identifiantFacture;
	private String compteDebit;
	private long mntOper; // montant de la facture a débiter + frais
	private long mntFacture; // montant da la facture sans les frais
	private long mntFrais; // montant des frais
	private long mntMarchand; // montant de la part de la banque
	private long mntFraisMarchand; // frais monta&nt part marchand
	private long mntTimbre; // fris de timbre
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getFacturier() {
		return facturier;
	}
	public void setFacturier(String facturier) {
		this.facturier = facturier;
	}
	public String getIdentifiantFacture() {
		return identifiantFacture;
	}
	public void setIdentifiantFacture(String identifiantFacture) {
		this.identifiantFacture = identifiantFacture;
	}
	public String getCompteDebit() {
		return compteDebit;
	}
	public void setCompteDebit(String compteDebit) {
		this.compteDebit = compteDebit;
	}
	public long getMntOper() {
		return mntOper;
	}
	public void setMntOper(long mntOper) {
		this.mntOper = mntOper;
	}
	public long getMntFacture() {
		return mntFacture;
	}
	public void setMntFacture(long mntFacture) {
		this.mntFacture = mntFacture;
	}
	public long getMntFrais() {
		return mntFrais;
	}
	public void setMntFrais(long mntFrais) {
		this.mntFrais = mntFrais;
	}
	public long getMntMarchand() {
		return mntMarchand;
	}
	public void setMntMarchand(long mntMarchand) {
		this.mntMarchand = mntMarchand;
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
	public PaieTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaieTest(String client, String facturier, String identifiantFacture, String compteDebit, long mntOper,
			long mntFacture, long mntFrais, long mntMarchand, long mntFraisMarchand, long mntTimbre) {
		super();
		this.client = client;
		this.facturier = facturier;
		this.identifiantFacture = identifiantFacture;
		this.compteDebit = compteDebit;
		this.mntOper = mntOper;
		this.mntFacture = mntFacture;
		this.mntFrais = mntFrais;
		this.mntMarchand = mntMarchand;
		this.mntFraisMarchand = mntFraisMarchand;
		this.mntTimbre = mntTimbre;
	}
	@Override
	public String toString() {
		return "PaieTest [client=" + client + ", facturier=" + facturier + ", identifiantFacture=" + identifiantFacture
				+ ", compteDebit=" + compteDebit + ", mntOper=" + mntOper + ", mntFacture=" + mntFacture + ", mntFrais="
				+ mntFrais + ", mntMarchand=" + mntMarchand + ", mntFraisMarchand=" + mntFraisMarchand + ", mntTimbre="
				+ mntTimbre + "]";
	}
	
	
	
	
}
