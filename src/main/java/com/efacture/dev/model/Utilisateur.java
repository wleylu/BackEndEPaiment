package com.efacture.dev.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Utilisateur {
	@Id
	private String login;
	private String nom;
	private String prenom;
	private String password;
	private String password1;
	private String password2;
	private String password3;
	private String email;
	private String tel;
	private String client;
	private String habilitation;
	private int validation = 0;
	private int status = 0;
	private int bloquser = 0;
	private int typePlafond;
	private int typeComfirmation;
	private String mdpOublie;
	private int cptNbTransaction;
	private int cptMontant;
	private String token;
	private String adCm;
	private Boolean reinitialiser;
	private Boolean init;
	private int tentative;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateMdp = new Date(System.currentTimeMillis());
	@OneToOne
	@JoinColumn(name = "filiale_id",referencedColumnName = "id")
	private Filiale filiale;
	@OneToOne
	 @JoinColumn(name="agence_id", referencedColumnName = "id")
	private Agence agence;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateCreation = new Date(System.currentTimeMillis());

	private String loginAdd;
	
	private String loginMaj;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateMaj = new Date(System.currentTimeMillis());

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String login, String nom, String prenom, String password, String password1, String password2,
			String password3, String email, String tel, String client, String habilitation, int validation, int status,
			int bloquser, int typePlafond, int typeComfirmation, String mdpOublie, int cptNbTransaction, int cptMontant,
			String token, String adCm, Boolean reinitialiser, Boolean init, Date dateCreation, int tentative, Date dateMdp) {
		super();
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.password1 = password1;
		this.password2 = password2;
		this.password3 = password3;
		this.email = email;
		this.tel = tel;
		this.client = client;
		this.habilitation = habilitation;
		this.validation = validation;
		this.status = status;
		this.bloquser = bloquser;
		this.typePlafond = typePlafond;
		this.typeComfirmation = typeComfirmation;
		this.mdpOublie = mdpOublie;
		this.cptNbTransaction = cptNbTransaction;
		this.cptMontant = cptMontant;
		this.token = token;
		this.adCm = adCm;
		this.reinitialiser = reinitialiser;
		this.init = init;
		this.dateCreation = dateCreation;
		this.tentative = tentative;
		this.dateMdp = dateMdp;
	}
	
	public Utilisateur(String login, String nom, String prenom, String password, String password1, String password2,
			String password3, String email, String tel, String client, String habilitation, int validation, int status,
			int bloquser, int typePlafond, int typeComfirmation, String mdpOublie, int cptNbTransaction, int cptMontant,
			String token, String adCm, Boolean reinitialiser, Boolean init, int tentative, Date dateCreation,
			String loginAdd, String loginMaj, Date dateMaj, Date dateMdp) {
		super();
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.password1 = password1;
		this.password2 = password2;
		this.password3 = password3;
		this.email = email;
		this.tel = tel;
		this.client = client;
		this.habilitation = habilitation;
		this.validation = validation;
		this.status = status;
		this.bloquser = bloquser;
		this.typePlafond = typePlafond;
		this.typeComfirmation = typeComfirmation;
		this.mdpOublie = mdpOublie;
		this.cptNbTransaction = cptNbTransaction;
		this.cptMontant = cptMontant;
		this.token = token;
		this.adCm = adCm;
		this.reinitialiser = reinitialiser;
		this.init = init;
		this.tentative = tentative;
		this.dateCreation = dateCreation;
		this.loginAdd = loginAdd;
		this.loginMaj = loginMaj;
		this.dateMaj = dateMaj;
		this.dateMdp = dateMdp;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHabilitation() {
		return habilitation;
	}

	public void setHabilitation(String habilitation) {
		this.habilitation = habilitation;
	}

	public int getValidation() {
		return validation;
	}

	public void setValidation(int validation) {
		this.validation = validation;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getPassword3() {
		return password3;
	}

	public void setPassword3(String password3) {
		this.password3 = password3;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getBloquser() {
		return bloquser;
	}

	public void setBloquser(int bloquser) {
		this.bloquser = bloquser;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getTypePlafond() {
		return typePlafond;
	}

	public void setTypePlafond(int typePlafond) {
		this.typePlafond = typePlafond;
	}

	public String getMdpOublie() {
		return mdpOublie;
	}

	public void setMdpOublie(String mdpOublie) {
		this.mdpOublie = mdpOublie;
	}

	public int getCptNbTransaction() {
		return cptNbTransaction;
	}

	public void setCptNbTransaction(int cptNbTransaction) {
		this.cptNbTransaction = cptNbTransaction;
	}

	public int getCptMontant() {
		return cptMontant;
	}

	public void setCptMontant(int cptMontant) {
		this.cptMontant = cptMontant;
	}

	public int getTypeComfirmation() {
		return typeComfirmation;
	}

	public void setTypeComfirmation(int typeComfirmation) {
		this.typeComfirmation = typeComfirmation;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAdCm() {
		return adCm;
	}

	public void setAdCm(String adCm) {
		this.adCm = adCm;
	}

	public Boolean getReinitialiser() {
		return reinitialiser;
	}

	public void setReinitialiser(Boolean reinitialiser) {
		this.reinitialiser = reinitialiser;
	}

	public Boolean getInit() {
		return init;
	}

	public void setInit(Boolean init) {
		this.init = init;
	}

	public int getTentative() {
		return tentative;
	}

	public void setTentative(int tentative) {
		this.tentative = tentative;
	}

	public String getLoginAdd() {
		return loginAdd;
	}

	public void setLoginAdd(String loginAdd) {
		this.loginAdd = loginAdd;
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
	
	
	public Filiale getFiliale() {
		return filiale;
	}

	
	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}

	
	public Agence getAgence() {
		return agence;
	}

	
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	
	public Date getDateMdp() {
		return dateMdp;
	}

	public void setDateMdp(Date dateMdp) {
		this.dateMdp = dateMdp;
	}

	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password
				+ ", password1=" + password1 + ", password2=" + password2 + ", password3=" + password3 + ", email="
				+ email + ", tel=" + tel + ", client=" + client + ", habilitation=" + habilitation + ", validation="
				+ validation + ", status=" + status + ", bloquser=" + bloquser + ", typePlafond=" + typePlafond
				+ ", typeComfirmation=" + typeComfirmation + ", mdpOublie=" + mdpOublie + ", cptNbTransaction="
				+ cptNbTransaction + ", cptMontant=" + cptMontant + ", token=" + token + ", adCm=" + adCm
				+ ", reinitialiser=" + reinitialiser + ", init=" + init + ", tentative=" + tentative + ", dateMdp="
				+ dateMdp + ", filiale=" + filiale + ", agence=" + agence + ", dateCreation=" + dateCreation
				+ ", loginAdd=" + loginAdd + ", loginMaj=" + loginMaj + ", dateMaj=" + dateMaj + "]";
	}

}
