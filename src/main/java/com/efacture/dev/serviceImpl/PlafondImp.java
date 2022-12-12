package com.efacture.dev.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Plafond;
import com.efacture.dev.repository.PlafondRepository;
import com.efacture.dev.service.ServicePlanfond;
@Service
public class PlafondImp implements ServicePlanfond {
	@Autowired
	private PlafondRepository plafondRepository;
	@Override
	public Plafond addPlafond(Plafond plafond) {
		
			Plafond plaf = plafondRepository.findByNombreFactureAndMontantMax(plafond.getNombreFacture(), plafond.getMontantMax());
			if (plaf == null) {
				Plafond plafond1 = new Plafond(plafond.getNombreFacture(),plafond.getMontantMax(), plafond.getTypePlafond(), plafond.getLoginAdd(), plafond.getDateAdd(), plafond.getLoginMaj(), plafond.getDateMaj()); 
				return plafondRepository.save(plafond1);
			}
			return new Plafond();
	}

	@Override
	public List<Plafond> plafond() {
		// TODO Auto-generated method stub
		return plafondRepository.findAll();
	}

	@Override
	public Plafond updatePlafond(Plafond plafond) {
		plafond.setDateMaj(new Date(System.currentTimeMillis()));
		Plafond plafond1 = plafondRepository.findById(plafond.getNombreFacture()).get();
		if (plafond1 != null) {
			return plafondRepository.save(plafond);
		}
		return new Plafond();
	}

	@Override
	public Plafond detailPlafond(Long idPlafond) {
		return plafondRepository.findById(idPlafond).get();
	}

	@Override
	public List<Plafond> plafondParType(int type) {
		// TODO Auto-generated method stub
		return plafondRepository.findByTypePlafondOrderByIdPlafondDesc(type);
	}
	
}
