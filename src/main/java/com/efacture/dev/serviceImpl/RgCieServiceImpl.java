package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.ReglementCie;
import com.efacture.dev.repository.RgCieRepository;
import com.efacture.dev.service.RgCieService;
@Service
public class RgCieServiceImpl implements RgCieService {
	@Autowired
	private RgCieRepository rgCieRepository;

	@Override
	public ReglementCie addReglement(ReglementCie reglementCie) {
		try {
		
			return rgCieRepository.save(reglementCie);
		} catch (Exception e) {
			
			return new ReglementCie();
		}
	}

	@Override
	public ReglementCie updateReglement(ReglementCie reglementCie) {
		try {
			ReglementCie currentRgCie = rgCieRepository.findById(reglementCie.getIdRgCie()).get();
			if (currentRgCie != null) {
			
				return rgCieRepository.save(currentRgCie);
			} else {
				
				return new ReglementCie();
			}
		} catch (Exception e) {
			return new ReglementCie();
		}
	}

	@Override
	public List<ReglementCie> listeReglement() {
		try {
			List<ReglementCie> rgCie = rgCieRepository.findAll();
			if (rgCie != null) {
				
				return rgCie;
			} else {
				
				return new ArrayList<>();
			}
		} catch (Exception e) {
			
			return new ArrayList<>();
		}
	}

	@Override
	public List<ReglementCie> getReglementByStatut(String statut) {
		try {
			List<ReglementCie> rgCie = rgCieRepository.findByStatut(statut);
			if (rgCie != null) {
				
				return rgCie;
			} else {
				
				return new ArrayList<>();
			}
		} catch (Exception e) {
		
			return new ArrayList<>();
		}
	}

}



