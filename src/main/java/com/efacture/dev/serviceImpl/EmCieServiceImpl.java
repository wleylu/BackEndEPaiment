package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.efacture.dev.model.EmmissionCie;
import com.efacture.dev.repository.EmCieRepository;
import com.efacture.dev.service.EmCieService;

@Service
public class EmCieServiceImpl implements EmCieService{

	
		@Autowired
		private EmCieRepository emCieRepository;
		@SuppressWarnings("unused")
		@Override
		public List<EmmissionCie> getByIdabon(String idabon) {
			try {
				List<EmmissionCie> idabonne = emCieRepository.findByIdabonner(idabon);
				EmmissionCie EmissionCie= new EmmissionCie();
				if (idabonne != null) {
					
					return idabonne;
				}else {
					
					return new ArrayList<>();
				}
			} catch (Exception e) {
				
				return new ArrayList<>();
			}
		}
		@Override
		public List<EmmissionCie> getByStatut(String statut) {
			try {
				List<EmmissionCie> statuts = emCieRepository.findByStatut(statut);
				if (statuts != null) {
				
					return statuts;
				}else {
					
					return new ArrayList<>();
				}
			} catch (Exception e) {
				
				return new ArrayList<>();
			}
		}
		@SuppressWarnings("unused")
		@Override
		public EmmissionCie updateStatut(EmmissionCie EmissionCie) {
			try {
				EmmissionCie EmissionCie2 = new EmmissionCie();
				EmmissionCie currentEmissionCie = emCieRepository.findByIdabonAndPerfact(EmissionCie.getIdabon(), EmissionCie.getPerfact());
				if (currentEmissionCie != null) {
				
					currentEmissionCie.setStatut(EmissionCie.getStatut());
					return emCieRepository.save(currentEmissionCie);
				} else {
					
					return new EmmissionCie();
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new EmmissionCie();
			}
		}
		@Override
		public EmmissionCie getByIdAbonAndPeriode(String idabon, String perfact) {
			
			try {
				EmmissionCie IdAbonAndPeriode = emCieRepository.findByIdabonAndPerfact(idabon, perfact);
				if (IdAbonAndPeriode != null) {
					
					return IdAbonAndPeriode;
				}else {
					
					return new EmmissionCie();
				}
			} catch (Exception e) {
			
				return new EmmissionCie();
			}
		}

	}
