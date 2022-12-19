package com.efacture.dev.service;

import com.efacture.dev.DTO.CompteMarchandDTO;
import com.efacture.dev.model.MessageStatut;

public interface ServiceTransaction {
	public MessageStatut addTransaction(CompteMarchandDTO marchand);

}
