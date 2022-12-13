package com.efacture.dev.DTO;

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
    private String loginAdd;
    private String loginMaj;
    

}
