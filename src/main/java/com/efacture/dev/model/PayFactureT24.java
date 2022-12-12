package com.efacture.dev.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PayFactureT24 {
	private String statut="1";
	private String Nooper;
	private String refExterne;
	
	
	public PayFactureT24(String statut, String nooper, String refExterne) {
		super();
		this.statut = statut;
		Nooper = nooper;
		this.refExterne = refExterne;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getNooper() {
		return Nooper;
	}
	public void setNooper(String nooper) {
		Nooper = nooper;
	}
	public String getRefExterne() {
		return refExterne;
	}
	public void setRefExterne(String refExterne) {
		this.refExterne = refExterne;
	}
	
	
}
