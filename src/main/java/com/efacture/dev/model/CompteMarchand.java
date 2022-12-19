package com.efacture.dev.model;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class CompteMarchand implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String client;
	private String refTransaction;
	private String codeTransaction;
	private double montant;
	private String sexe;
	private String nomPrenom;
	private String nom;
	private String prenom;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateNais;
	private int statut = 1;
	private String typeCpt;
	private String numCpt;
	private String numCptContribuable;
	private String regCrc;
	private int optionCm;
	private String raisonSocial;
	private String agec;
	private String tel;
	private String autreContact;
	private String pieceId;
	private Date dateExpir;
	private Date dateDelivr;
	private String email;
	private String login;
	@Column(length = 1)
	private String valide="N";
	@Column(length = 2)
	private String etatoper;
	private String codeConfirmation;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateValidCode;	
	private String adCm;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateModification = new Date(System.currentTimeMillis());
	
	private String loginModification;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateDesactivation;
	private String loginDesactivation;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateCreation = new Date(System.currentTimeMillis());

	/*
	 * @OneToMany(mappedBy = "compteMarchand", fetch = FetchType.LAZY) private
	 * Collection<Comptes> comptes;
	 */
	
	@OneToOne
	 @JoinColumn(name="agence_id", referencedColumnName = "id")
	private Agence agence;
	/*
	 * @Transient private List<Commission> commission;
	 * 
	 * @Transient private Collection<Comptes> comptesInactif;
	 */
	
	private String loginAdd;
	
	public CompteMarchand(String client, String nom, String prenom) {
		super();
		this.client = client;
		this.nom = nom;
		this.prenom = prenom;
	}

	public CompteMarchand() {

		super();

	}

	

	public CompteMarchand(String client) {
		super();
		this.client = client;
	}

	/*
	 * @JsonIgnore public CompteMarchand(List<Comptes> comptes) { super();
	 * this.comptes = comptes; }
	 */
	public CompteMarchand(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}

	public CompteMarchand(String client, String sexe, String nomPrenom, String nom, String prenom, Date dateNais,
			int statut, String typeCpt, String numCpt, String numCptContribuable, String regCrc, int optionCm,
			String raisonSocial, String agec, String tel, String autreContact, String pieceId, Date dateExpir,
			Date dateDelivr, String email, String login, String adCm, Date dateModification, String loginModification,
			Date dateDesactivation, String loginDesactivation, Collection<Comptes> comptes,Collection<Comptes> comptesInactif,String loginAdd,List<Commission> commission) {
		super();
		this.client = client;
		this.sexe = sexe;
		this.nomPrenom = nomPrenom;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.statut = statut;
		this.typeCpt = typeCpt;
		this.numCpt = numCpt;
		this.numCptContribuable = numCptContribuable;
		this.regCrc = regCrc;
		this.optionCm = optionCm;
		this.raisonSocial = raisonSocial;
		this.agec = agec;
		this.tel = tel;
		this.autreContact = autreContact;
		this.pieceId = pieceId;
		this.dateExpir = dateExpir;
		this.dateDelivr = dateDelivr;
		this.email = email;
		this.login = login;
		this.adCm = adCm;
		this.dateModification = dateModification;
		this.loginModification = loginModification;
		this.dateDesactivation = dateDesactivation;
		this.loginDesactivation = loginDesactivation;
		/*
		 * this.comptes = comptes; this.comptesInactif = comptesInactif;
		 * this.commission=commission;
		 */
		this.loginAdd = loginAdd;
	}

	public CompteMarchand(String client, String sexe, String nomPrenom, String nom, String prenom, Date dateNais,
			int statut, String typeCpt, String numCpt, String numCptContribuable, String regCrc, int optionCm,
			String raisonSocial, String agec, String tel, String autreContact, String pieceId, Date dateExpir,
			Date dateDelivr, String email, String login, String adCm, Date dateModification, String loginModification,
			Date dateDesactivation, String loginDesactivation, Date dateCreation, List<Comptes> comptes,Collection<Comptes> comptesInactif,List<Commission> commission) {
		super();
		this.client = client;
		this.sexe = sexe;
		this.nomPrenom = nomPrenom;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.statut = statut;
		this.typeCpt = typeCpt;
		this.numCpt = numCpt;
		this.numCptContribuable = numCptContribuable;
		this.regCrc = regCrc;
		this.optionCm = optionCm;
		this.raisonSocial = raisonSocial;
		this.agec = agec;
		this.tel = tel;
		this.autreContact = autreContact;
		this.pieceId = pieceId;
		this.dateExpir = dateExpir;
		this.dateDelivr = dateDelivr;
		this.email = email;
		this.login = login;
		this.adCm = adCm;
		this.dateModification = dateModification;
		this.loginModification = loginModification;
		this.dateDesactivation = dateDesactivation;
		this.loginDesactivation = loginDesactivation;
		this.dateCreation = dateCreation;
		/*
		 * this.comptes = comptes; this.comptesInactif = comptesInactif;
		 * this.commission=commission;
		 */
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	

	public String getCodeConfirmation() {
		return codeConfirmation;
	}

	public void setCodeConfirmation(String codeConfirmation) {
		this.codeConfirmation = codeConfirmation;
	}

	public Date getDateValidCode() {
		return dateValidCode;
	}

	public void setDateValidCode(Date dateValidCode) {
		this.dateValidCode = dateValidCode;
	}

	public String getValide() {
		return valide;
	}

	public void setValide(String valide) {
		this.valide = valide;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefTransaction() {
		return refTransaction;
	}

	public void setRefTransaction(String refTransaction) {
		this.refTransaction = refTransaction;
	}

	public String getCodeTransaction() {
		return codeTransaction;
	}

	public void setCodeTransaction(String codeTransaction) {
		this.codeTransaction = codeTransaction;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/*
	 * public void setComptes(Collection<Comptes> comptes) { this.comptes = comptes;
	 * }
	 */
	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public String getTypeCpt() {
		return typeCpt;
	}

	public void setTypeCpt(String typeCpt) {
		this.typeCpt = typeCpt;
	}

	public String getNumCpt() {
		return numCpt;
	}

	public void setNumCpt(String numCpt) {
		this.numCpt = numCpt;
	}

	public String getNumCptContribuable() {
		return numCptContribuable;
	}

	public void setNumCptContribuable(String numCptContribuable) {
		this.numCptContribuable = numCptContribuable;
	}

	public String getRegCrc() {
		return regCrc;
	}

	public void setRegCrc(String regCrc) {
		this.regCrc = regCrc;
	}

	public int getOptionCm() {
		return optionCm;
	}

	public void setOptionCm(int optionCm) {
		this.optionCm = optionCm;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public String getAgec() {
		return agec;
	}

	public void setAgec(String agec) {
		this.agec = agec;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAutreContact() {
		return autreContact;
	}

	public void setAutreContact(String autreContact) {
		this.autreContact = autreContact;
	}

	public String getPieceId() {
		return pieceId;
	}

	public void setPieceId(String pieceId) {
		this.pieceId = pieceId;
	}

	public Date getDateExpir() {
		return dateExpir;
	}

	public void setDateExpir(Date dateExpir) {
		this.dateExpir = dateExpir;
	}

	public Date getDateDelivr() {
		return dateDelivr;
	}

	public void setDateDelivr(Date dateDelivr) {
		this.dateDelivr = dateDelivr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAdCm() {
		return adCm;
	}

	public void setAdCm(String adCm) {
		this.adCm = adCm;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public String getLoginModification() {
		return loginModification;
	}

	public void setLoginModification(String loginModification) {
		this.loginModification = loginModification;
	}

	public Date getDateDesactivation() {
		return dateDesactivation;
	}

	public void setDateDesactivation(Date dateDesactivation) {
		this.dateDesactivation = dateDesactivation;
	}

	public String getLoginDesactivation() {
		return loginDesactivation;
	}

	public void setLoginDesactivation(String loginDesactivation) {
		this.loginDesactivation = loginDesactivation;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	

	/*
	 * public Collection<Comptes> getComptes() { return comptes; }
	 * 
	 * public void setComptes(List<Comptes> comptes) { this.comptes = comptes; }
	 * 
	 * 
	 * 
	 * public Collection<Comptes> getComptesInactif() { return comptesInactif; }
	 * 
	 * public void setComptesInactif(Collection<Comptes> comptesInactif) {
	 * this.comptesInactif = comptesInactif; }
	 */

	public String getEtatoper() {
		return etatoper;
	}

	public void setEtatoper(String etatoper) {
		this.etatoper = etatoper;
	}

	public String getLoginAdd() {
		return loginAdd;
	}

	public void setLoginAdd(String loginAdd) {
		this.loginAdd = loginAdd;
	}

	/*
	 * public List<Commission> getCommission() { return commission; }
	 * 
	 * public void setCommission(List<Commission> commission) { this.commission =
	 * commission; }
	 */

	@Override
	public String toString() {
		return "CompteMarchand [client=" + client + ", sexe=" + sexe + ", nomPrenom=" + nomPrenom + ", nom=" + nom
				+ ", prenom=" + prenom + ", dateNais=" + dateNais + ", statut=" + statut + ", typeCpt=" + typeCpt
				+ ", numCpt=" + numCpt + ", numCptContribuable=" + numCptContribuable + ", regCrc=" + regCrc
				+ ", optionCm=" + optionCm + ", raisonSocial=" + raisonSocial + ", agec=" + agec + ", tel=" + tel
				+ ", autreContact=" + autreContact + ", pieceId=" + pieceId + ", dateExpir=" + dateExpir
				+ ", dateDelivr=" + dateDelivr + ", email=" + email + ", login=" + login + ", adCm=" + adCm
				+ ", dateModification=" + dateModification + ", loginModification=" + loginModification
				+ ", dateDesactivation=" + dateDesactivation + ", loginDesactivation=" + loginDesactivation
				+ ", dateCreation=" + dateCreation + ",dateValidCode="+ dateValidCode +", loginAdd="+ loginAdd + "]";
	}

}