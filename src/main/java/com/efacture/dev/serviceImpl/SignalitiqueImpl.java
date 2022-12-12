package com.efacture.dev.serviceImpl;

 

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Comptes;

import com.efacture.dev.model.SignalitiqueTest;
import com.efacture.dev.repository.SignalitiqueRepository;
import com.efacture.dev.service.ServiceSignalitique;

@Service
@Transactional
public class SignalitiqueImpl implements ServiceSignalitique {
    
	@Autowired
    private SignalitiqueRepository signalitiqueRepository;

    @SuppressWarnings("unused")
	public SignalitiqueTest ajouterCm(SignalitiqueTest c) {
		//Commission com = reposistoryCommission.findById(c.getCommission().getIdCommission()).get();
		Comptes cpt = null;     //c.getComptes().get(0);
		SignalitiqueTest marchand = new SignalitiqueTest();
		SignalitiqueTest march = new SignalitiqueTest();
		
		try {
			if (signalitiqueRepository.findByClient(c.getClient()) == null && signalitiqueRepository.findByEmail(c.getEmail())==null){
				marchand.setClient(c.getClient());
				marchand.setSexe(c.getSexe());
				marchand.setNomPrenom(c.getNomPrenom());
				marchand.setNom(c.getNom());
				marchand.setPrenom(c.getPrenom());
				marchand.setDateNais(c.getDateNais());
				marchand.setStatut(c.getStatut());
				marchand.setTypeCpt(c.getTypeCpt());
				marchand.setNumCpt(c.getSexe());
				marchand.setNumCptContribuable(c.getNumCptContribuable());
				marchand.setRegCrc(c.getRegCrc());
				marchand.setOptionCm(c.getOptionCm());
				marchand.setRaisonSocial(c.getRaisonSocial());
				marchand.setAgec(c.getAgec());
				marchand.setTel(c.getTel());
				marchand.setPieceId(c.getPieceId());
				marchand.setDateExpir(c.getDateExpir());
				marchand.setDateDelivr(c.getDateDelivr());
				marchand.setEmail(c.getEmail());
				marchand.setLogin(c.getLogin());
				marchand.setAdCm(c.getAdCm());
				marchand.setDateModification(c.getDateModification());
				//marchand.setCommission(com);				
				march=signalitiqueRepository.save(marchand);
				
				
				//cpt.setCompteMarchand(marchand);
				
			}
		} catch (Exception e) {
			march= new SignalitiqueTest();
		}
		
		
		
		return march;
	}

    @Override
    public List<SignalitiqueTest> listMarchands() {
    	try {
    		return signalitiqueRepository.findAll();
		} catch (Exception e) {
			return new ArrayList<>();
		}
        
        
    }
    
    @Override
    public SignalitiqueTest getMarchand(String client) {
    	try {
    		SignalitiqueTest compteMarchand = signalitiqueRepository.findById(client).get();
			if (compteMarchand != null) {
		        return compteMarchand;
			} else {
				return new SignalitiqueTest();
			}
		} catch (Exception e) {
			return new SignalitiqueTest();
		}
    }

	
		
		
		
	}
    
