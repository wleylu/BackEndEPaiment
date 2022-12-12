package com.efacture.dev.service;

 

import java.util.List;
import com.efacture.dev.model.SignalitiqueTest;


public interface ServiceSignalitique {
	
	public SignalitiqueTest ajouterCm(SignalitiqueTest c);
	public List<SignalitiqueTest> listMarchands();
	public SignalitiqueTest getMarchand(String client);
	
}