package com.efacture.dev.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class MessageStatut implements Serializable {
	
	@Id
	private String codeMsg;
	private String libelle;

}
