package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.ReglementSodeci;
import com.efacture.dev.repository.RgSodeciRepository;
import com.efacture.dev.service.RgSodeciService;
@Service
public class RgSodeciServiceImpl implements RgSodeciService {
	@Autowired
	private RgSodeciRepository rgSodeciRepository;
	@Override
	public ReglementSodeci addReglement(ReglementSodeci reglementSodeci) {
		try {
			
			return rgSodeciRepository.save(reglementSodeci);
		} catch (Exception e) {
			
			return new ReglementSodeci();
		}
	}

	@Override
	public ReglementSodeci updateReglement(ReglementSodeci reglementSodeci) {
		try {
			ReglementSodeci currentRgSodeci = rgSodeciRepository.findById(reglementSodeci.getIdRgSodeci()).get();
			if (currentRgSodeci != null) {
				
				return rgSodeciRepository.save(currentRgSodeci);
			}else {
				
				return new ReglementSodeci();
			}
		} catch (Exception e) {
			return new ReglementSodeci();
		}
	}

	@Override
	public List<ReglementSodeci> listeReglement() {
		try {
			List<ReglementSodeci> rgSodeci = rgSodeciRepository.findAll();
			if (rgSodeci !=null) {
				
				return rgSodeci;
			}else {
				
				return new ArrayList<>();
			}
		} catch (Exception e) {
			
			return new ArrayList<>();
		}
	}

	@Override
	public List<ReglementSodeci> getReglementByStatut(String statut) {
		try {
			List<ReglementSodeci> rgSodeci = rgSodeciRepository.findByStatut(statut);
			if (rgSodeci !=null) {
			
				return rgSodeci;
			}else {
				
				return new ArrayList<>();
			}
		} catch (Exception e) {
			
			return new ArrayList<>();
		}
	}

}
