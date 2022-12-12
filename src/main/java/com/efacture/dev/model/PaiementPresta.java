package com.efacture.dev.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaiementPresta {
	
	@JsonProperty("CodeOperateur")
	String CodeOperateur;
    @JsonProperty("RefContrat")
    String RefContrat;
    @JsonProperty("RefFacture")
    String RefFacture;
    @JsonProperty("DateReglement")
    String DateReglement;
    @JsonProperty("HeureReglement")
    long HeureReglement;
    @JsonProperty("MontantReglement")
    long MontantReglement;
    @JsonProperty("NumeroRecu")
    String NumeroRecu;
    @JsonProperty("TypeCanal")
    String TypeCanal;
    @JsonProperty("dateExpfacture")
    String dateExpfacture;
	
}
