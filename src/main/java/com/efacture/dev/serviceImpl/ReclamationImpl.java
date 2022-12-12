package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.efacture.dev.model.Consultation;
import com.efacture.dev.model.Reclamation;
import com.efacture.dev.repository.ReclamationRepository;
import com.efacture.dev.service.ServiceReclamation;
//import com.efacture.dev.service.ServiceFacturier;

@Service
public class ReclamationImpl implements ServiceReclamation {
	@Autowired
	private ReclamationRepository reclamationRepository;

	/*
	 * @Override public ServiceConsulte consultation(String intituleFacturier,
	 * String identFacture) {
	 * return facturieRepository.findByIntituleFactAndIdentfact(intituleFacturier,
	 * identFacture); }
	 */

	@Override
	public Reclamation postReclamation(Reclamation reclamation) {
		return reclamationRepository.save(reclamation) ;
	}

	public List<Reclamation> getReclamByLogin(String login) {
		// TODO Auto-generated method stub
		return reclamationRepository.findByLogin(login);
	}
	@Override
	public List<Reclamation> listeReclamantion(){
		try {
			return reclamationRepository.findAll();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public List<Reclamation> rechercheReclamation(Date firstDate, Date lastDate, String login, String nom, String facturier,
			String reference) {
		try {
			return reclamationRepository.findByDateReclamationBetweenAndLoginContainingIgnoreCaseAndNomContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndReferenceContainingIgnoreCase(firstDate, lastDate, login, nom, facturier, reference);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}

	@Override
	public List<Reclamation> getReclamation(String login, String nom, String facturier, String reference) {
		try {
			return reclamationRepository.findByLoginContainingIgnoreCaseAndNomContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndReferenceContainingIgnoreCase(login, nom, facturier, reference);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}

}
