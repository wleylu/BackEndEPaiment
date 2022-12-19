package com.efacture.dev.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_transaction;
	@Value("PAIE|M|M|")
	private String prefixe;
	private String facturier;
	@Temporal(TemporalType.DATE)
	private Date datOper = new Date(System.currentTimeMillis());;
	private String codOper;
	private String identifiantFacture;
	private String compteDebit;
	private String compteCredit;
	private long mntOper; // montant de la facture a débiter + frais
	private long mntFacture; // montant da la facture sans les frais
	private long mntFrais; // montant des frais
	private long mntMarchand; // montant de la part de la banque
	private long mntFraisMarchand; // frais monta&nt part marchand
	private long mntTimbre; // fris de timbre
	private String libelleOper; // libelle de l'opération
	private String compteCom; // compte de commision
	private String refOld;
	private String statutTraitement;
	private long codeTraitement;
	
	private double  montant;
	private String refTransaction;
	private String codeTransaction;
	private String codeConfirmation;	
	private String loginAdd;
	


	public Transaction(long id_transaction, String prefixe, String facturier, Date datOper, String codOper,
			String identifiantFacture, String compteDebit, String compteCredit, long mntOper, long mntFacture,
			long mntFrais, long mntMarchand, long mntFraisMarchand, long mntTimbre, String libelleOper,
			String compteCom, String refOld, String statutTraitement, long codeTraitement) {
		super();
		this.id_transaction = id_transaction;
		this.prefixe = prefixe;
		this.facturier = facturier;
		this.datOper = datOper;
		this.codOper = codOper;
		this.identifiantFacture = identifiantFacture;
		this.compteDebit = compteDebit;
		this.compteCredit = compteCredit;
		this.mntOper = mntOper;
		this.mntFacture = mntFacture;
		this.mntFrais = mntFrais;
		this.mntMarchand = mntMarchand;
		this.mntFraisMarchand = mntFraisMarchand;
		this.mntTimbre = mntTimbre;
		this.libelleOper = libelleOper;
		this.compteCom = compteCom;
		this.refOld = refOld;
		this.statutTraitement = statutTraitement;
		this.codeTraitement = codeTraitement;
	}

	

	@Override
	public String toString() {
		return "Transaction [id_transaction=" + id_transaction + ", prefixe=" + prefixe + ", facturier=" + facturier + ", datOper=" + datOper
				+ ", codOper=" + codOper + ", identifiantFacture=" + identifiantFacture + ", compteDebit=" + compteDebit
				+ ", compteCredit=" + compteCredit + ", mntOper=" + mntOper + ", mntFacture=" + mntFacture
				+ ", mntFrais=" + mntFrais + ", mntMarchand=" + mntMarchand + ", mntFraisMarchand=" + mntFraisMarchand
				+ ", mntTimbre=" + mntTimbre + ", libelleOper=" + libelleOper + ", compteCom=" + compteCom + ", refOld="
				+ refOld + ", statutTraitement=" + statutTraitement + ", codeTraitement=" + codeTraitement + "]";
	}

	
}