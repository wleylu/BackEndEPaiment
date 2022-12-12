package com.efacture.dev.serviceImpl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.EmmissionSodeci;
import com.efacture.dev.repository.EmSodeciRepository;
import com.efacture.dev.service.EmSodeciService;


@Service
public class EmSodeciServiceImpl implements EmSodeciService {
	@Autowired
	private EmSodeciRepository emSodeciRepository;
	@SuppressWarnings("unused")
	@Override
	public List<EmmissionSodeci> getByIdabon(String idabon) {
		try {
			List<EmmissionSodeci> idabonne = emSodeciRepository.findByIdabonner(idabon);
			EmmissionSodeci emmissionSodeci= new EmmissionSodeci();
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
	public List<EmmissionSodeci> getByStatut(String statut) {
		try {
			List<EmmissionSodeci> statuts = emSodeciRepository.findByStatut(statut);
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
	public EmmissionSodeci updateStatut(EmmissionSodeci emmissionSodeci) {
		try {
			EmmissionSodeci emmissionSodeci2 = new EmmissionSodeci();
			EmmissionSodeci currentEmmissionSodeci = emSodeciRepository.findByIdabonAndPerfact(emmissionSodeci.getIdabon(), emmissionSodeci.getPerfact());
			if (currentEmmissionSodeci != null) {
				
				currentEmmissionSodeci.setStatut(emmissionSodeci.getStatut());
				return emSodeciRepository.save(currentEmmissionSodeci);
			} else {
			
				return new EmmissionSodeci();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new EmmissionSodeci();
		}
	}
	@Override
	public EmmissionSodeci getByIdAbonAndPeriode(String idabon, String perfact) {
		try {
			EmmissionSodeci IdAbonAndPeriode = emSodeciRepository.findByIdabonAndPerfact(idabon, perfact);
			if (IdAbonAndPeriode != null) {
				
				return IdAbonAndPeriode;
			}else {
				
				return new EmmissionSodeci();
			}
		} catch (Exception e) {
			
			return new EmmissionSodeci();
		}
	}

}
