package com.efacture.dev.DTO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteMarchandDTO {
	
	private Long id;
    private String refTransaction;
    private String codeTransaction;      
    private String nom;
    private String prenom;
    private double montant;
    private String tel;
    private String pieceId;    
    private String email;
    private String codeConfirmation;
    @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateValidCode;	
    private String loginAdd;
    private String loginMaj;
    @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateModification = new Date(System.currentTimeMillis());
    private String loginModification;
    

}
