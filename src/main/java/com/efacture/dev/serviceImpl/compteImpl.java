package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Comptes;
import com.efacture.dev.repository.CmRepository;
import com.efacture.dev.repository.CompteRepository;
import com.efacture.dev.service.ServiceCompte;

@Service
@Transactional
public class compteImpl implements ServiceCompte {
	@Autowired
	private CompteRepository compte;
	@Autowired
	private CmRepository cmRepository;

	@Override
	public List<Comptes> cpt() {

		return compte.findAll();
	}

	@Override
	public Comptes getCompteById(String cptId) {

		return compte.findByCompte(cptId);
	}

	@Override
	public Comptes updateCpt(Comptes cpt) {
		Comptes cp = compte.findById(cpt.getCompte()).get();
//Comptes cp1 = compte.findByCompteMarchand(cpt.getCompteMarchand());
//cpts1.setCompteMarchand(cpt.getCompteMarchand());
		if (cp != null) {
			cp.setCompte(cpt.getCompte());
			cp.setAgence(cpt.getAgence());
			cp.setNcg(cpt.getNcg());
			cp.setLibNcg(cpt.getLibNcg());
			cp.setCoddci(cpt.getCoddci());
			cp.setExpl(cpt.getExpl());
			cp.setStatut(cpt.getStatut());
			return compte.save(cp);
		} else {
			return new Comptes();
		}

	}

	@Override
	public List<Comptes> getByCompteMarchand(CompteMarchand code) {

		return compte.findByCompteMarchand(code);
	}

	@SuppressWarnings("unused")
	@Override
	public Comptes ajouterCompte(String code, Comptes cpt) {
		Collection<Comptes> cp1 = new ArrayList<Comptes>();
		CompteMarchand cm = new CompteMarchand();
		if (cmRepository.findByClient(code) != null) {
			CompteMarchand cm1 = cmRepository.findByClient(code);
			cpt.setCompteMarchand(cm1);
			Comptes cp2 = compte.save(cpt);
			cp1.add(cp2);
//cm.setComptes(cp1);
			return compte.save(cpt);
		} else {
			return new Comptes();
		}
	}
// @Override
// public List<Comptes> trouverListeCompte(Long c) {
//
// return //compte.findAllCompte(c);
// }

	@Override
	public List<Comptes> getByCompteMarchand(String code) {
// TODO Auto-generated method stub
		return compte.findByCompteMarchand(code);
	}

	@Override
	public List<Comptes> CompteByStatut(String code) {
		// TODO Auto-generated method stub
		return compte.findByCodeAndStatut(code);
	}

}
