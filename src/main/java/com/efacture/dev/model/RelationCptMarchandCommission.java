package com.efacture.dev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class RelationCptMarchandCommission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String client;
	private long idCommission;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public long getIdCommission() {
		return idCommission;
	}
	public void setIdCommission(long idCommission) {
		this.idCommission = idCommission;
	}
	
}
