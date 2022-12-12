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
public class ErreurGenere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateErreur=new Date(System.currentTimeMillis());
    private int httpStatusCode; // 200, 201, 400, 500
    private String methode;
    private String login;
    private String description;
    private String message;
    @Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private Date heureErreur = new Date(System.currentTimeMillis());
	public Date getHeureErreur() {
		return heureErreur;
	}

	public void setHeureErreur(Date heureErreur) {
		this.heureErreur = heureErreur;
	}

	public ErreurGenere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ErreurGenere(Date dateErreur, int httpStatusCode, String methode, String message) {
		super();
		this.dateErreur = dateErreur;
		this.httpStatusCode = httpStatusCode;
		this.methode = methode;
		this.message = message;
	}

	public ErreurGenere(long id, Date dateErreur, int httpStatusCode, String methode, String message) {
		super();
		this.id = id;
		this.dateErreur = dateErreur;
		this.httpStatusCode = httpStatusCode;
		this.methode = methode;
		this.message = message;
	}

	public ErreurGenere(Date dateErreur, int httpStatusCode, String methode, String login, String description,
			String message) {
		super();
		this.dateErreur = dateErreur;
		this.httpStatusCode = httpStatusCode;
		this.methode = methode;
		this.login = login;
		this.description = description;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateErreur() {
		return dateErreur;
	}

	public void setDateErreur(Date dateErreur) {
		this.dateErreur = dateErreur;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getMethode() {
		return methode;
	}

	public void setMethode(String methode) {
		this.methode = methode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErreurGenere [id=" + id + ", dateErreur=" + dateErreur + ", httpStatusCode=" + httpStatusCode
				+ ", methode=" + methode + ", message=" + message + "]";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
    
}
