package com.efacture.dev.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.efacture.dev.model.TypePaiement;
import com.efacture.dev.repository.TypePaiementRepository;
import com.efacture.dev.service.ServiceTypePaie;

@Service
public class TypePaieImp implements ServiceTypePaie{
	@Autowired
	private TypePaiementRepository typePaiementRepository;

	@Override
	public TypePaiement addTypePaie(TypePaiement typePaiement) {
		
			return typePaiementRepository.save(typePaiement);
	
		
	}

	@Override
	public List<TypePaiement> TypePaie() {
		// TODO Auto-generated method stub
		return typePaiementRepository.findAll();
	}

	@Override
	public TypePaiement updateTypePaie(TypePaiement typePaiement) {
		TypePaiement typePaie = typePaiementRepository.findById(typePaiement.getType()).get();
		if (typePaie != null) {
			return typePaiementRepository.save(typePaie);
		}
		return new TypePaiement();
	}

	@Override
	public TypePaiement detailTypePaie(int typePaiement) {
		// TODO Auto-generated method stub
		return typePaiementRepository.findById(typePaiement).get();
	}

	@Override
	public TypePaiement rechercheByType(int type) {
		return typePaiementRepository.findByType(type);
	}
	
}
