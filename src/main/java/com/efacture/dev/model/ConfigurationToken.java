package com.efacture.dev.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ConfigurationToken {
	@Id
	private String login;
	private String token;
	private Date entreToken;
	private Date expirationToken;
	public ConfigurationToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ConfigurationToken(String login, String token, Date entreToken, Date expirationToken) {
		super();
		this.setLogin(login);
		this.token = token;
		this.entreToken = entreToken;
		this.expirationToken = expirationToken;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getEntreToken() {
		return entreToken;
	}
	public void setEntreToken(Date entreToken) {
		this.entreToken = entreToken;
	}
	public Date getExpirationToken() {
		return expirationToken;
	}
	public void setExpirationToken(Date expirationToken) {
		this.expirationToken = expirationToken;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
