package com.efacture.dev.model;

public class AuthenticationRequest {
	
	private String login;
	private String password1;
	
	
	public AuthenticationRequest(String login, String password1) {
		super();
		this.login = login;
		this.password1 = password1;
	}
	
	public AuthenticationRequest()
	{
		
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword(String password1) {
		this.password1 = password1;
	}
	
	

}
