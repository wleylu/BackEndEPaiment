package com.efacture.dev.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PayFactureGS2E {
	private String CodeTraitement="1";
	private String MessageTraitement;
	private String ReferenceContratClient;
	private String ReferenceDeTransaction;
	private String TypeTansaction;
	private String MontantReglement;
	private String NumeroRecu;
	private String NumeroDeFacture;
	

	public PayFactureGS2E(String codeTraitement, String messageTraitement, String referenceContratClient,
			String referenceDeTransaction, String typeTansaction, String montantReglement, String numeroRecu,
			String numeroDeFacture) {
		super();
		CodeTraitement = codeTraitement;
		MessageTraitement = messageTraitement;
		ReferenceContratClient = referenceContratClient;
		ReferenceDeTransaction = referenceDeTransaction;
		TypeTansaction = typeTansaction;
		MontantReglement = montantReglement;
		NumeroRecu = numeroRecu;
		NumeroDeFacture = numeroDeFacture;
	}

	public String getCodeTraitement() {
		return CodeTraitement;
	}

	public void setCodeTraitement(String codeTraitement) {
		CodeTraitement = codeTraitement;
	}

	public String getMessageTraitement() {
		return MessageTraitement;
	}

	public void setMessageTraitement(String messageTraitement) {
		MessageTraitement = messageTraitement;
	}

	public String getReferenceContratClient() {
		return ReferenceContratClient;
	}

	public void setReferenceContratClient(String referenceContratClient) {
		ReferenceContratClient = referenceContratClient;
	}

	public String getReferenceDeTransaction() {
		return ReferenceDeTransaction;
	}

	public void setReferenceDeTransaction(String referenceDeTransaction) {
		ReferenceDeTransaction = referenceDeTransaction;
	}

	public String getTypeTansaction() {
		return TypeTansaction;
	}

	public void setTypeTansaction(String typeTansaction) {
		TypeTansaction = typeTansaction;
	}

	public String getMontantReglement() {
		return MontantReglement;
	}

	public void setMontantReglement(String montantReglement) {
		MontantReglement = montantReglement;
	}

	public String getNumeroRecu() {
		return NumeroRecu;
	}

	public void setNumeroRecu(String numeroRecu) {
		NumeroRecu = numeroRecu;
	}

	public String getNumeroDeFacture() {
		return NumeroDeFacture;
	}

	public void setNumeroDeFacture(String numeroDeFacture) {
		NumeroDeFacture = numeroDeFacture;
	}
	
}
