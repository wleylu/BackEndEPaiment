package com.efacture.dev.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class UtilisateurDTO {
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
	private int validation=0;
	private int status=0;
	private int bloquser=0;
	private int typePlafond;
	private int typeComfirmation;
	private String mdpOublie;
	private int cptNbTransaction;
	private int cptMontant;
	private String token;
	@Temporal(TemporalType.DATE)
	private Date dateCreation =new Date(System.currentTimeMillis());
	public UtilisateurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UtilisateurDTO(String login, String nom, String prenom, String password, String password1, String password2,
			String password3, String email, String tel, String client, String habilitation, int validation, int status,
			int bloquser, int typePlafond, int typeComfirmation, String mdpOublie, int cptNbTransaction, int cptMontant,
			String token, Date dateCreation) {
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
		this.setToken(token);
		this.dateCreation = dateCreation;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
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
	public int getBloquser() {
		return bloquser;
	}
	public void setBloquser(int bloquser) {
		this.bloquser = bloquser;
	}
	public int getTypePlafond() {
		return typePlafond;
	}
	public void setTypePlafond(int typePlafond) {
		this.typePlafond = typePlafond;
	}
	public int getTypeComfirmation() {
		return typeComfirmation;
	}
	public void setTypeComfirmation(int typeComfirmation) {
		this.typeComfirmation = typeComfirmation;
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
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
